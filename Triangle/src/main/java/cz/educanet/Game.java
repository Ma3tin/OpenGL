package cz.educanet;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL33;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

public class Game {

    private static final float vertices[] = {
            -0.7f, -0.7f, 0.0f,
            0.7f, -0.7f, 0.0f,
            0.7f, 0.7f, 0.0f,
            -0.7f, -0.7f, 0.0f,
            -0.7f, 0.7f, 0.0f,
            0.7f, 0.7f, 0.0f
    };
    private static int vaoID;
    private static int vboID;

    public static void makeUp(long okno) {
        Shaders.initShaders();
        vaoID = GL33.glGenVertexArrays();
        vboID = GL33.glGenBuffers();
        GL33.glBindVertexArray(vaoID);
        GL33.glBindBuffer(GL33.GL_ARRAY_BUFFER, vboID);
        FloatBuffer fb = BufferUtils.createFloatBuffer(vertices.length).put(vertices).flip();
        GL33.glBufferData(GL33.GL_ARRAY_BUFFER, fb, GL33.GL_STATIC_DRAW);
        GL33.glVertexAttribPointer(0, 3, GL33.GL_FLOAT, false, 0, 0);
        GL33.glEnableVertexAttribArray(0);
        MemoryUtil.memFree(fb);
    }
    public static void vykreslit(long okno) {
        GL33.glUseProgram(Shaders.programID);
        GL33.glBindVertexArray(vaoID);
        GL33.glDrawArrays(GL33.GL_TRIANGLES, 0, vertices.length / 3);
    }

    public static void again(long okno) {
    }
}
