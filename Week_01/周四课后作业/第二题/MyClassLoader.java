import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Object hello = new MyClassLoader().findClass("D:\\Hello.xlass").newInstance();
        hello.getClass().getDeclaredMethod("hello").invoke(hello, null);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(name);
        byte[] bytes = getClassBytes(file);
        if (bytes == null) {
            throw new ClassNotFoundException();
        }
        Class<?> clazz = this.defineClass("Hello", bytes, 0, bytes.length);
        return clazz;
    }

    private byte[] getClassBytes(File f) {
        if (!f.exists()) {
            return null;
        }
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
             BufferedInputStream in = new BufferedInputStream(new FileInputStream(f))) {
            byte[] buffer = new byte[1];
            byte temp = (byte) 255;
            while (-1 != (in.read(buffer, 0, 1))) {
                buffer[0] = (byte) (temp - buffer[0]);
                bos.write(buffer, 0, 1);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
