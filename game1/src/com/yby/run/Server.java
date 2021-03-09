package com.yby.run;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Server extends Thread {

	//�������������
	private ServerSocket serverSocket;
	private ServerGui management;
	private Thread thread;
	private List<Thread> threadList;
	private Iterator<Thread> iter;
	private List<Socket> socketList;
	
	//�����������ý����ಢ��ʼ���б�
	public Server(ServerGui atmServer) {
		threadList = new ArrayList<Thread>();
		socketList = new ArrayList<Socket>();
		management =  atmServer;
		start();
	}
	
	//�˳������̲߳��ҹرշ�����
	@SuppressWarnings("deprecation")
	public void stopMe() {
		Iterator<Socket> iterS = socketList.iterator();
		while(iterS.hasNext()) {
			try {
				iterS.next().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		iter = threadList.iterator();
		while(iter.hasNext()) {
			iter.next().stop();
		}
		stop();
	}
	
	//ʵ��run����
	@Override
	public void run() {
		try {
	        // Create a server socket
	        serverSocket = new ServerSocket(8000);
	        

	      while (true) {
	        // Listen for a new connection request
	        Socket socket = serverSocket.accept();

	      

	        // Create a new thread for the connection
	        thread = new ServerThread(socket);
	        
	        socketList.add(socket);
	        threadList.add(thread);
	      }
	    }
	    catch(IOException ex) {
	      ex.printStackTrace();
	    }
	}
	
	//�ڲ���̳�Thread��ÿ���߳�����һ���ͻ���
	class ServerThread extends Thread {
	    private Socket socket; //��������

	    /** Construct a thread */
	    public ServerThread(Socket socket) {
	        this.socket = socket;
	        start();
	    }
	    
	    /** Run a thread */
	    public void run() {
	        try {
	            // Create data input and output streams
	            DataInputStream  din  = new DataInputStream(socket.getInputStream());
		        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

	            // Continuously serve the client
	            while (true) {
	                try {
	                	String string = din.readUTF();
	                	
	                	// Send message to the management 
	                	//management.doit(string);
	                	boolean a = true;
	                	a = management.doit(string);
	                	dout.writeBoolean(a);
	                	System.out.println(a);
	                }
	                catch(EOFException e) {
	                	break;
	                }     
	            }
	        }
	        catch(IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

}



