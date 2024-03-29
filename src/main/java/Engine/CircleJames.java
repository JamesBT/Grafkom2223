package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class CircleJames extends ObjectJames {

    public List<Float> getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(List<Float> centerPoint) {
        this.centerPoint = centerPoint;
    }

    List<Float> centerPoint;
    Float radiusX;
    Float radiusY;

    String tipe;
    public CircleJames(List<ShaderModuleData> shaderModuleDataList, Vector4f color, String tipe, double titikPusatx,
                       double titikpusaty , double jari2x, double jari2y) {
        super(shaderModuleDataList);
        this.vertices = new ArrayList<>();this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        this.tipe = tipe;
        createCircle(titikPusatx,titikpusaty,jari2x, jari2y);
        setupVAOVBO();

    }
    public CircleJames(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
//        createCircle();
        setupVAOVBO();
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index), GL_STATIC_DRAW);
    }
    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void createCircle(double titikpusatx, double titikpusaty, double jari2x, double jari2y){
        if (tipe.equals("circle")) {
            for (double i = 0; i < 360; i += 360 / 360) {
                float x = (float) (titikpusatx + (jari2x * Math.round(Math.cos(Math.toRadians(i)) * 100) / 100));
                float y = (float) (titikpusaty + (jari2y * Math.round(Math.sin(Math.toRadians(i)) * 100) / 100));
                vertices.add(new Vector3f(x, y, 0.0f));
            }
        }else if (tipe.equals("triangle")){
            for (double i = 0; i < 360; i += 360 / 3) {
                float x = (float) (titikpusatx + (jari2x * Math.round(Math.cos(Math.toRadians(i)) * 100) / 100));
                float y = (float) (titikpusaty + (jari2y * Math.round(Math.sin(Math.toRadians(i)) * 100) / 100));
                vertices.add(new Vector3f(x, y, 0.0f));
            }
        }else if (tipe.equals("square")){
            for (double i = 45; i < 360+45; i += 90) {
                float x = (float) (titikpusatx + (jari2x * Math.round(Math.cos(Math.toRadians(i)) * 100) / 100));
                float y = (float) (titikpusaty + (jari2y * Math.round(Math.sin(Math.toRadians(i)) * 100) / 100));
                vertices.add(new Vector3f(x, y, 0.0f));
            }
        }

    }

    public void changeCircle(double titikpusatx, double titikpusaty, double jari2x, double jari2y){
        this.vertices = new ArrayList<>();
        if (tipe.equals("circle")) {
            for (double i = 0; i < 360; i += 360 / 360) {
                float x = (float) (titikpusatx + (jari2x * Math.round(Math.cos(Math.toRadians(i)) * 100) / 100));
                float y = (float) (titikpusaty + (jari2y * Math.round(Math.sin(Math.toRadians(i)) * 100) / 100));
                vertices.add(new Vector3f(x, y, 0.0f));
            }
        }else if (tipe.equals("triangle")){
            for (double i = 0; i < 360; i += 360 / 3) {
                float x = (float) (titikpusatx + (jari2x * Math.round(Math.cos(Math.toRadians(i)) * 100) / 100));
                float y = (float) (titikpusaty + (jari2y * Math.round(Math.sin(Math.toRadians(i)) * 100) / 100));
                vertices.add(new Vector3f(x, y, 0.0f));
            }
        }else if (tipe.equals("square")){
            for (double i = 45; i < 360+45; i += 90) {
                float x = (float) (titikpusatx + (jari2x * Math.round(Math.cos(Math.toRadians(i)) * 100) / 100));
                float y = (float) (titikpusaty + (jari2y * Math.round(Math.sin(Math.toRadians(i)) * 100) / 100));
                vertices.add(new Vector3f(x, y, 0.0f));
            }
        }
        setupVAOVBO();
    }

//    public void draw(){
//        drawSetup();
//        // Draw the vertices
//        //optional
//        glLineWidth(10); //ketebalan garis
//        glPointSize(10); //besar kecil vertex
//        if (tipe.equals("circle")){
//            glDrawArrays(GL_TRIANGLE_FAN,0, vertices.size());
//        }else if (tipe.equals("triangle")){
//            glDrawArrays(GL_TRIANGLES,0, vertices.size());
//        }else if (tipe.equals("square")){
//            glDrawArrays(GL_TRIANGLE_FAN,0, vertices.size());
//        }
//
//    }


}
