package edu.upc.eetac.dsa.alejandro;

/**
 * Hello world!
 *
 */

import java.io.*;
import java.net.*;



public class Client
{
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("You have to pass the server name and the server port");
            System.exit(-1);
        }
        String server = args[0];
        int port = Integer.parseInt(args[1]);

        byte[] data = new byte[0];
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName(server), port);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(dp);

        byte[] buffer = new byte[1496];
        dp = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(dp);
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(dp.getData()));
        String time = dis.readUTF();
        System.out.println(time);
    }
}