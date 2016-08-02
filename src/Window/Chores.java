package Window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chores {

    private JFrame frame;
    private List<String> roger;
    private List<String> pos;
    private List<String> tyler;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    Chores window = new Chores();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Chores() {
        initialize();
    }




    private List<String> getAvailableItems(){
        pos = new ArrayList<>();
        readfile r = new readfile();
        r.openFile();
        pos = r.readFile();
        r.closeFile();
        return pos;
    }


    private void createFrame(){
        frame = new JFrame();
        frame.setBounds(100, 100, 487, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

    }

    public void getRogerList(){
        roger = new ArrayList<>();
        Random r = new Random();
        int l = pos.size();
        for(int i = 0;i<l/2;i++){
            int select = r.nextInt(pos.size());
            roger.add(pos.get(select));
            pos.remove(select);

        }
    }


    public void createList1(){
        JList list = new JList();
        list.setModel(new AbstractListModel() {
            public int getSize() {
                return roger.size();
            }
            public Object getElementAt(int index) {
                return roger.get(index);
            }
        });

        list.setBounds(31, 27, 170, 200);
        frame.getContentPane().add(list);
        list.setVisible(true);
    }
    public void getTylerList(){
        tyler = new ArrayList<>();
        tyler.addAll(pos);
    }

    public void createList2(){

        JList list_1 = new JList();
        list_1.setModel(new AbstractListModel() {

            public int getSize() {
                return tyler.size();
            }
            public Object getElementAt(int index) {
                return tyler.get(index);
            }
        });
        list_1.setBounds(288, 27, 170, 200);
        frame.getContentPane().add(list_1);
        list_1.setVisible(true);
    }
    public void createLabelRoger(){
        JLabel lblRoger = new JLabel("Roger");
        lblRoger.setBounds(80, 6, 61, 16);
        frame.getContentPane().add(lblRoger);
    }
    public void createLabelTyler(){
        JLabel lblTyler = new JLabel("Tyler");
        lblTyler.setBounds(337, 6, 61, 16);
        frame.getContentPane().add(lblTyler);
    }
    private void initialize() {
        createFrame();
        pos = getAvailableItems();
        getRogerList();
        getTylerList();
        createList1();
        createList2();
        createLabelRoger();
        createLabelTyler();
    }
}
