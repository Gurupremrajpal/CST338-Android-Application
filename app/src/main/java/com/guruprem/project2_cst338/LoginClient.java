package com.guruprem.project2_cst338;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class LoginClient
{

    String HOST;
    int PORT;
    Socket s;
    BufferedInputStream in;
    DataOutputStream out;

    public LoginClient(String host,int port) throws IOException
    {
        this.HOST = host;
        this.PORT = port;
        s = new Socket();
        s.connect(new InetSocketAddress(HOST, PORT), 1000); // Connection timeout

        s.setSoTimeout(1*1000); // receive data timeout.

        in = new BufferedInputStream(s.getInputStream());
        out = new DataOutputStream(s.getOutputStream());
    }

    public void close()
    {
        String[] frame = {"QUIT"};
        try {
            sframe(frame);
            s.close();
        }
        catch(Exception e) {}
    }

    public void sframe(String[] frame) throws IOException
    {
        for (String chunk : frame)
        {
            out.writeInt(chunk.length());
            out.write(chunk.getBytes());
        }
        out.writeInt(0);
        out.flush();
    }

    public ArrayList<String> rframe() throws IOException
    {
        ArrayList<String> frame = new ArrayList<>();
        int lenData = 1;
        byte[] byteLen = new byte[4];
        byte[] byteData;
        int pos = 0;
        String chunk = "";
        while(lenData > 0)
        {
            in.read(byteLen,pos,pos+4);
            lenData = ByteBuffer.wrap(byteLen).getInt();
            byteData = new byte[lenData];
            in.read(byteData,pos,pos+lenData);
            chunk = new String(byteData);
            frame.add(chunk);
        }
        return frame;
    }


}

