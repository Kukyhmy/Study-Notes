----------------------------
����Unsafe��				|
----------------------------
	# ���䷽������
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe) field.get(null);