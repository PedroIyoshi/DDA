DDA l1 = new DDA(1, 1);

void setup(){
  size(1000, 1000);
  scale(20, 20);
  l1.setWeight(10);
  l1.setColor(color(0, 0, 200));
}

void draw(){
  background(255, 255, 255);
  l1.setValues(mouseX, mouseY);
  l1.show();
}
