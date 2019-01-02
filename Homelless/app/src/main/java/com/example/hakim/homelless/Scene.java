package com.example.hakim.homelless;

public class Scene {
    private Situation[] Arr;
    private String ques;
    public Scene(Situation Sit1, Situation Sit2,Situation Sit3, String ques){
        Arr = new Situation[3];
        Arr[0] = Sit1;
        Arr[1] = Sit2;
        Arr[2] = Sit3;
        this.ques = ques;
    }



    public Situation getSit(int index){
        return Arr[index];
    }

    public void setSit(int index, Situation Sit){
        Arr[index] = Sit;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }
}
