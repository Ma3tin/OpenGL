package cz.educanet;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33;

public class Main {

    public static void main(String[] args) throws Exception {
        GLFW.glfwInit();
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);

        long okno = GLFW.glfwCreateWindow(800, 600, "My first window", 0, 0);
        if (okno == 0) {
            GLFW.glfwTerminate();
            throw new Exception("Can't open window");
        }
        GLFW.glfwMakeContextCurrent(okno);

        GL.createCapabilities();
        GL33.glViewport(0, 0, 800, 600);

        GLFW.glfwSetFramebufferSizeCallback(okno, (win, w, h) -> {
            GL33.glViewport(0, 0, w, h);
        });

        Game.makeUp(okno);
        while (!GLFW.glfwWindowShouldClose(okno)) {
            if (GLFW.glfwGetKey(okno, GLFW.GLFW_KEY_ESCAPE) == GLFW.GLFW_PRESS)
                GLFW.glfwSetWindowShouldClose(okno, true);
            GL33.glClearColor(1f, 0f, 1f, 1f);
            GL33.glClear(GL33.GL_COLOR_BUFFER_BIT);
            Game.vykreslit(okno);
            Game.again(okno);
            GLFW.glfwSwapBuffers(okno);
            GLFW.glfwPollEvents();
        }

        GLFW.glfwTerminate();
    }

}
