class DDA{
  float x1, y1, x2, y2, salto, xinc, yinc, dx, dy, x, y;
  int size = 5;
  color c = color(0, 0, 0);
  DDA(float x, float y){
    this.x1 = x;
    this.y1 = y;
  }
  
  void setColor(color c){
    this.c = c; 
  }
  
  void setWeight(int size){
    this.size = size; 
  }
  
  void setValues(float x, float y){
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
  
  void show(){
    strokeWeight(0);
    fill(c);
    while(this.x < this.x2){
      square(round(this.x), round(this.y), size);
      this.x += this.xinc;
      this.y += this.yinc;
    }
  }
  
}
