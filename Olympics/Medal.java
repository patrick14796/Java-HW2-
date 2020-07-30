/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * Medal class 
 * 
 * @param Medal_type - the type of the medal (bronze,silver,gold)
 * @param tournament - the name of the tournament
 * @param year -  the year of the tournament
 * Creation of A Medal 
 */

package Olympics;


public class Medal{
    private enum type{bronze,silver,gold};
    private type med;
    private String tournament;
    private int year; 

    public Medal(){
        this.med=type.bronze;
        this.tournament="SCE tournament";
        this.year=2020;
    }
    public Medal(type m,String s,int y){
        this.med=m;
        this.tournament=s;
        this.year=y;
    }
    public int getMedalYear(){
        return this.year;
    }
    
    public boolean setMedalYear(int x){
        if (x<1820){
            throw new RuntimeException("Inufficient year!!!!" + x);
        }
        else {
            this.year=x;
            return true;
        }
    }
 
    public String getTournament(){
        return this.tournament;
    }
    public boolean setTournament(String str){
        this.tournament=str;
        return true;
    }

    public type getMedalType(){
        return this.med;
    }
    public  boolean setMedalType(int x){
        switch (x) {
            case 1:
                this.med=type.gold;
                return true;
        
            case 2:
                this.med=type.silver;
                return true;
            case 3:
                this.med=type.bronze;
                return true;
            default:
               return false;
        }
    }
    public boolean equals(Object other){
        boolean answer=false;
        if(other instanceof Medal)
        {
         answer=(this.getMedalYear()==((Medal)other).getMedalYear()&& this.getTournament()==((Medal)other).getTournament()&& this.getMedalType()==((Medal)other).getMedalType());
        }
        return answer;
    }
    public String toString(){
        return "Medal type: " + getMedalType()
        + ", year: " + getMedalYear()
        + ", recive in Tournament: " + getTournament();
    }
}
