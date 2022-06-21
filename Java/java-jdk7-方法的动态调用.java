------------------------
������̬����			|
------------------------

	import java.lang.invoke.MethodHandle;
	import java.lang.invoke.MethodHandles;
	import java.lang.invoke.MethodHandles.Lookup;
	import java.lang.invoke.MethodType;

	public class Main {

		public void println(Object value) {
			System.out.println("value=" + value);
		}
		
		public static MethodHandle getMethodHandle(Object receiver) throws NoSuchMethodException, IllegalAccessException {
			Lookup lookup = MethodHandles.lookup();
			//�����ķ������ͺͲ�������
			MethodType methodType = MethodType.methodType(void.class,Object.class);
			//��ȡָ������ķ������ƣ��Լ��������ͣ��󶨵��ö���
			return lookup.findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
		}
		
		public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, Throwable {
			getMethodHandle(System.out).invoke("����System.out");	//����System.out
			getMethodHandle(new Main()).invoke("����Main");		//value=����Main
		}
	}