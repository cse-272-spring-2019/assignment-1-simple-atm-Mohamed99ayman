import java.util.Stack;




public class History {

   private Stack <String > back=new Stack();
   private Stack <String > back2=new Stack();
    private Stack <String > next=new Stack();
    mainmenu m=new mainmenu();


        public void setBack(String back) {
        this.back.push(back);
        if(this.back.size()+this.next.size()>5){
            while (!this.back.isEmpty()){
                back2.push(this.back.peek());
                this.back.pop();
            }
            back2.pop();
            while (!this.back2.isEmpty()){
                this.back.push(back2.peek());
                this.back2.pop();
            }

        }
    }
    public void res(){
            while (!next.isEmpty())
            {
                back.push(next.peek());
                next.pop();
            }
    }


    public String backClicked(){
            if(back.isEmpty()) {
                return "No transactions";
            }
           else if(m.label1.getText()==back.peek()){
               System.out.println(m.label1.getText());
               System.out.println("ASd");
                next.push(back.peek());
                back.pop();
                if(!back.isEmpty()){

                    next.push(back.peek());
                    back.pop();
                    return next.peek();
                }
                else
                    return "No transactions";
            }
           else {
                String x = back.peek();
                back.pop();
                next.push(x);
                return x;
            }
    }
    public String nextClicked(){
        if(next.isEmpty()){return "No transactions";}

           else if(m.label1.getText()==next.peek()){
               back.push(next.peek());
               next.pop();
               if(!next.isEmpty()){
                   back.push(next.peek());
                   next.pop();
                   return back.peek();
               }
                   else
                       return "No transactions";
            }
            else {
                String x = next.peek();
                next.pop();
                back.push(x);
                return  back.peek();
            }
    }

}
