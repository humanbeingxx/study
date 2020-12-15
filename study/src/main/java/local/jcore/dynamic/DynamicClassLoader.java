package local.jcore.dynamic;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class DynamicClassLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        return createClass(name);
    }

    private Class<?> createClass(String className) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager stdManager = compiler.getStandardFileManager(null, null, null);

        try (MemJavaFileManager manager = new MemJavaFileManager(stdManager)) {
            String fileName = extractFileName(className);
            Iterable<? extends JavaFileObject> fileObjects = stdManager.getJavaFileObjects(fileName);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager,
                    null, null, null, fileObjects);
            if (task.call()) {
                byte[] classBytes = manager.getBytes().get(className);
                return defineClass(null, classBytes, 0, classBytes.length);
            } else {
                throw new IllegalStateException();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String extractFileName(String className) {
        String classFileName;
        if (!className.contains(".")) {
            classFileName = className;
        } else {
            classFileName = className.substring(className.lastIndexOf(".") + 1);
        }
        if (!classFileName.contains("$")) {
            return DynamicClassLoader.class.getClassLoader().getResource("clz/" + classFileName + ".java").getFile();
        } else {
            classFileName = classFileName.substring(0, classFileName.indexOf("$"));
            return DynamicClassLoader.class.getClassLoader().getResource("clz/" + classFileName + ".java").getFile();
        }
    }

    private static class MemJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {

        private Map<String, byte[]> bytes = new HashMap<>();

        /**
         * Creates a new instance of ForwardingJavaFileManager.
         *
         * @param fileManager delegate to this file manager
         */
        protected MemJavaFileManager(JavaFileManager fileManager) {
            super(fileManager);
        }

        public Map<String, byte[]> getBytes() {
            return bytes;
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind,
                                                   FileObject sibling) throws IOException {
            if (kind == JavaFileObject.Kind.CLASS) {
                return new JavaFileObjectOutput(className);
            }
            return super.getJavaFileForOutput(location, className, kind, sibling);
        }

        private class JavaFileObjectOutput extends SimpleJavaFileObject {

            private String fileName = null;

            protected JavaFileObjectOutput(String fileName) {
                super(URI.create(fileName), Kind.CLASS);
                this.fileName = fileName;
            }

            @Override
            public OutputStream openOutputStream() {
                return new FilterOutputStream(new ByteArrayOutputStream()) {
                    @Override
                    public void close() throws IOException {
                        out.close();
                        bytes.put(fileName, ((ByteArrayOutputStream) out).toByteArray());
                    }
                };
            }
        }
    }


}
