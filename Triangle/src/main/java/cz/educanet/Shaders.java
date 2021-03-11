package cz.educanet;

import org.lwjgl.opengl.GL33;

public class Shaders {
    private static final String zdrojOne = "#version 330 core\n" +
            "layout (location = 0) in vec3 aPos;\n" +
            "void main()\n" +
            "{\n" +
            " gl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0);\n" +
            "}";

    private static final String zdrojTwo = "#version 330 core\n" +
            "out vec4 FragColor;\n" +
            "void main()\n" +
            "{\n" +
            "   FragColor = vec4(0.0f, 1.0f, 0.0f, 1.0f);\n" +
            "}\n";

    public static int vykreslovaniID;
    public static int fragmentID;
    public static int programID;

    public static void initShaders() {
        vykreslovaniID = GL33.glCreateShader(GL33.GL_VERTEX_SHADER);
        fragmentID = GL33.glCreateShader(GL33.GL_FRAGMENT_SHADER);
        GL33.glShaderSource(vykreslovaniID, zdrojOne);
        GL33.glCompileShader(vykreslovaniID);
        System.out.println(GL33.glGetShaderInfoLog(vykreslovaniID));
        GL33.glShaderSource(fragmentID, zdrojTwo);
        GL33.glCompileShader(fragmentID);
        System.out.println(GL33.glGetShaderInfoLog(fragmentID));
        programID = GL33.glCreateProgram();
        GL33.glAttachShader(programID, vykreslovaniID);
        GL33.glAttachShader(programID, fragmentID);
        GL33.glLinkProgram(programID);
        System.out.println(GL33.glGetProgramInfoLog(programID));
        GL33.glDeleteShader(vykreslovaniID);
        GL33.glDeleteShader(fragmentID);
    }

}
