import java.security.SecureRandom;

class machine implements Runnable{
    static int ticket=10000;
    int soldTicket;
    Thread m ;
    static int wantTicket;

    machine(String name){
        soldTicket=0;
        m=new Thread(this,name);
        m.start();
    }

    public void run(){
        while(soldOut()==true){
            soldTicket+=wantTicket;

        }
        System.out.println(m.getName()+"總共售出"+soldTicket+"張票。");
    }

    synchronized private static boolean soldOut(){
        while(ticket>0){
            SecureRandom randomNumber= new SecureRandom();
            wantTicket = 1+randomNumber.nextInt(4);
            if(ticket>=wantTicket){
                ticket -= wantTicket;
            return true;
            }else if(ticket<wantTicket){
                wantTicket = 1+randomNumber.nextInt(ticket);
                ticket -= wantTicket;
                return true;
            }

        }
        return false;
        
    }
}

public class Week3_Homework {
    public static void main(String[] args){
        machine machineA =new machine("Machine A");
        machine machineB =new machine("Machine B");
        machine machineC =new machine("Machine C");
        machine machineD =new machine("Machine D");
        
    }
}
