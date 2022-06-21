-------------------------
WebSocket
-------------------------
	# websocket �ͻ��˵Ľӿ�
	
	# ��̬����
		int NORMAL_CLOSURE = 1000;
			* �����رյ���Ϣ֡��״̬��

	# ��̬����
		

	# ���󷽷�
		CompletableFuture<WebSocket> sendText(CharSequence data, boolean last);
		CompletableFuture<WebSocket> sendBinary(ByteBuffer data, boolean last);
			* ������Ϣ, last��ʾ�Ƿ�Ϊ���һ֡

		CompletableFuture<WebSocket> sendPing(ByteBuffer message);
		CompletableFuture<WebSocket> sendPong(ByteBuffer message);
			* ��������

		CompletableFuture<WebSocket> sendClose(int statusCode, String reason);	
			* �ر�

		void request(long n);
			* ����ͳ�ƽ�����Ϣ�����ķ���

		String getSubprotocol();
		boolean isOutputClosed();
		boolean isInputClosed();
		void abort();

-------------------------
Builder
-------------------------
	# websocket ��builer�ӿ�
		Builder header(String name, String value);
			* �������ͷ

		Builder connectTimeout(Duration timeout);
			* ���ó�ʱʱ��

		Builder subprotocols(String mostPreferred, String... lesserPreferred);
			* ������Э��

		CompletableFuture<WebSocket> buildAsync(URI uri, Listener listener);
			* �첽��������

-------------------------
Listener
-------------------------
	# ��Ϣ�����ӿ�
		default void onOpen(WebSocket webSocket) { 
		default CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) 
		default CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) 
		default CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) 

		default CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) 
		default CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) 
		default void onError(WebSocket webSocket, Throwable error) 

		
		* ��Щ�ӿڷ���ȫ��Ĭ��ʵ�ֵ�
		* ���� onClose �� onError ��������, ��������������ִ��: webSocket.request(1);




-------------------------
�����Ŀͻ���
-------------------------
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * @author KevinBlandy
 *
 */
public class Client implements Test{
	
	public static void main(String[] args) throws Exception {
		
		// ִ���̳߳�
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		// ����������
		WebSocket.Listener listener = new Listener() {
			@Override
			public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
				String message = data.toString();
				System.out.println("�յ���������Ϣ:" + message + "���Ƿ������һ֡:" + last);
				if (last) {
					// ������һ����Ϣ����������Ϣ����ͳ��
					webSocket.request(1);
				}
				if (message.equalsIgnoreCase("bye")) {
					// �յ�����˵� "byte", �ͻ��������Ͽ�����
					webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "byte").whenComplete((websocket, throable) -> {
						// ��Դ�ͷ�
						executor.shutdown();
						System.out.println("�Ѿ��رպͷ���˵�channel");
					});
				}
	            return null;
			}
		};
		
		// ����websocket��builder
		HttpClient.newBuilder()
			.executor(executor)
			.build()
			.newWebSocketBuilder()
			.buildAsync(new URI("ws://localhost:1024/channel"), listener).whenComplete((webSocket, throable) -> {
				
				while (true) {
					webSocket.sendText("Hello�� " + System.currentTimeMillis(), true);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		
	}
	
	public static void json(Object object) {
		System.out.println(JSON.toJSONString(object, SerializerFeature.PrettyFormat));
	}
}
