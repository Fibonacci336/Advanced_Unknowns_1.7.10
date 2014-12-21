package com.fibonacci.advanced_unknowns.server.packet;

import com.fibonacci.advanced_unknowns.reference.References;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;

import java.util.*;

/**
 * Created by Fibonacci on 12/20/14.
 */
public class PacketPipeline extends MessageToMessageCodec<FMLProxyPacket, AbstractPacket>{

    private EnumMap<Side, FMLEmbeddedChannel> channels;
    private LinkedList<Class<? extends AbstractPacket>> packets = new LinkedList<Class<? extends AbstractPacket>>();
    private boolean isPostInit = false;

    public boolean registerPacket(Class<? extends AbstractPacket> clases){
        if(this.packets.size() > 256){
            System.err.println("Couldn't Register Packet: Max Amount of Packets Reached!");
            return false;
        }
        if(this.packets.contains(clases)){
            System.err.println("Couldn't Register Packet: Packet Already Registered!");
            return false;
        }

        if(this.isPostInit){
            System.err.println("Couldn't Register Packet: Packet Registered too Late!");
            return false;
        }

        this.packets.add(clases);
        return true;
    }
    public void init(){
        this.channels = NetworkRegistry.INSTANCE.newChannel(References.PACKET_CHANNEL_NAME, this);

        registerPackets();
    }
    public void postInitialize(){
        if(isPostInit)
            return;

        isPostInit = true;
        Collections.sort(this.packets, new Comparator<Class<? extends AbstractPacket>>() {
            @Override
            public int compare(Class<? extends AbstractPacket> o1, Class<? extends AbstractPacket> o2) {
                int com = String.CASE_INSENSITIVE_ORDER.compare(o1.getCanonicalName(), o1.getCanonicalName());

                if(com == 0){
                    com = o1.getCanonicalName().compareTo(o2.getCanonicalName());
                }
                return com;
            }
        });
    }
    public void registerPackets(){
        //Register Packets
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, List<Object> out) throws Exception {
        ByteBuf buffer = Unpooled.buffer();
        Class<? extends AbstractPacket> clases = msg.getClass();
        if(!this.packets.contains(clases))
            throw new NullPointerException("Couldn't Encode Packet: " + clases.getCanonicalName() + " has not been registered!");

            byte discriminator = (byte) this.packets.indexOf(clases);
            buffer.writeByte(discriminator);
            msg.encodeInto(ctx, buffer);

        FMLProxyPacket proxyPacket = new FMLProxyPacket(buffer.copy(), ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
        out.add(proxyPacket);



    }

    @Override
    protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception {
        ByteBuf payload = msg.payload();
        byte discriminator = payload.readByte();

        Class<? extends AbstractPacket> clases = this.packets.get(discriminator);
        if(clases == null)
            throw new NullPointerException("Couldn't Decode Packet: " + clases.getCanonicalName() + " has not been registered!");


        AbstractPacket abstractPacket = clases.newInstance();
        abstractPacket.decodeInto(ctx, payload.slice());

        EntityPlayer player;

        switch (FMLCommonHandler.instance().getEffectiveSide()) {
            case CLIENT:
                player = Minecraft.getMinecraft().thePlayer;
                abstractPacket.handleClientSide(player);
            case SERVER:
                INetHandler iNetHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
                player = ((NetHandlerPlayServer) iNetHandler).playerEntity;
                abstractPacket.handleServerSide(player);
                break;
            default:
        }

        out.add(abstractPacket);
    }
}
