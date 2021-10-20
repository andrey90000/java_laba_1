import Array.Array;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArray {
    private int a_1;
    private int a_2;
    private int a_3;
    @Before
    public void setUp() throws Exception{
         a_1=78;
         a_2=-8;
         a_3=9;

    }
    @Test
    public void testAdd(){

        Array a=new Array(0) ;
        a.add(a_1);
        a.add(a_2);
        a.add(a_3);

        Assert.assertEquals(3,a.getSize());
    }

    @Test
    public void testDelete(){
        Array a2 =new Array(5);
        a2.add(5);
        a2.add(3);
        a2.add(5);
        a2.add(2);
        a2.add(5);
        a2.delete(3);
        a2.delete(2);
        Assert.assertEquals(3, a2.getSize());
    }
    @Test
    public void testGetElem(){
        Array a3= new Array(1);
        a3.add(0);a3.add(1);a3.add(2);
        Object result=a3.getElem(1);
        Assert.assertEquals(1,result);
    }
    @Test
    public void testEquals(){
        Array a4=new Array(1);
        a4.add(4);a4.add(5);
        Array a5=new Array(1);
        a5.add(4);a5.add(5);
        Assert.assertEquals(true,a4.equals(a5));
    }
    @Test
    public void testToString(){
        Array a6=new Array(1);
        a6.add(4);a6.add(7);a6.add(8);
        String exp="[4, 7, 8]";
        Assert.assertEquals(exp,a6.toString());
    }

}
