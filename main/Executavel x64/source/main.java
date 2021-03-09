import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class main extends PApplet {

DDA l1 = new DDA(1, 1);

public void setup(){
  
  scale(20, 20);
  l1.setWeight(10);
  l1.setColor(color(0, 0, 200));
}

public void draw(){
  background(255, 255, 255);
  l1.setValues(mouseX, mouseY);
  l1.show();
}
class DDA{
  float x1, y1, x2, y2, salto, xinc, yinc, dx, dy, x, y;
  int size = 5;
  int c = color(0, 0, 0);
  DDA(float x, float y){
    this.x1 = x;
    this.y1 = y;
  }
  
  public void setColor(int c){
    this.c = c; 
  }
  
  public void setWeight(int size){
    this.size = size; 
  }
  
  public void setValues(float x, float y){
    this.x2 = x;
    this.x = this.x1;
    this.y2 = y;
    this.y = this.y1;
    this.dx = this.x2 - this.x1;
    this.dy = this.y2 - this.y1;
    this.salto = max(abs(this.dx), abs(this.dy));
    this.xinc = this.dx / this.salto; 
    this.yinc = this.dy / this.salto;
  }
  
  public void show(){
    strokeWeight(0);
    fill(c);
    while(this.x < this.x2){
      square(round(this.x), round(this.y), size);
      this.x += this.xinc;
      this.y += this.yinc;
    }
  }
  
}
  public void settings() {  size(1000, 1000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
