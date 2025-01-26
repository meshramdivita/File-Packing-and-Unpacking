import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MarvellousUnpack
{
    FileOutputStream outstream = null;

    public MarvellousUnpack(String src)throws Exception
    {
        unpack(src);
    }

    public void unpack(String filePath)throws Exception
    {
        try
        {
            FileInputStream  instream = new FileInputStream(filePath);

            byte header[] = new byte[100];
            int length = 0 ; 

            byte Magic[] = new byte[12];
            instream.read(Magic,0,Magic.length);

            String Magicstr = new String(Magic);

            if(!Magicstr.equals("Marevllous11"))
            {
                throw new InvalidFileException("Invalid packed file formate");
            }
            while((length = instream.read(header , 0 ,100))>0)
            {
                String str = new String (header);

                String ext = str.substring(str.lastIndexOf("/"));
                ext = ext.substring(1);

                String[] words  = ext.split("\\s");

                String filename = words[0];

                int size = Integer.parseInt(words[1]);

                byte arr[] = new byte[size];

                instream.read(arr,0,size);

                FileOutputStream fout = new FileOutputStream(filename);
                fout.write(arr,0,size);
            }
        }
        catch(InvalidFileException obj)
        {
            throw new InvalidFileException("Invalid packed file formate");
        }
        catch(Exception e)
        {}
    }
}

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MrevellousPackFront extends Template implements ActionListener
{
    JButton SUBMIT , PREVOUS;
    JLabel label1,label2,title;
    final JTextField text1,text2;
    
        public MrevellousPackFront()
        { 
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
            title = new JLabel("Marvellous Packing Portal ");
            Dimension size = title.getPreferredSize();
            title.setBounds(40,50,size.width+60,size.height);
            title.setFont(new Font ("Century",Font.BOLD,17));
            this.setForeground(Color.blue);
        
            label1 = new JLabel();
            label1.setText("Directory name");
            label1.setForeground(Color.white);
            label1.setBounds(350,50,size.width,size.height);
    
            text1 = new JTextField(15);
            Dimension tsize = text1.getPreferredSize();
            text1.setBounds(500,50,tsize.width,size.height);
            text1.setToolTipText("Enter name of directory");
    
            label2 = new JLabel();
            label2.setText("Directory file name");
            label2.setForeground(Color.white);
            label2.setBounds(350,100,size.width+60,size.height);
        
            text2 = new JTextField(15);
            text2.setBounds(500,100,tsize.width,tsize.height);
            text2.setToolTipText("Enter Destintaion file name");
    
            SUBMIT = new JButton("SUBMIT");
            Dimension bsize = SUBMIT.getPreferredSize();
            SUBMIT.setBounds(350,200,bsize.width,bsize.height);
            SUBMIT.addActionListener(this);
    
            PREVIOUS = new JButton("PREVIOUS");
            Dimension b2size = PREVIOUS.getPreferredSize();
            PREVIOUS.setBounds(500,200,b2size.width,b2size.height);
            PREVIOUS.addActionListener(this);

        _header.add(title);
        _content.add(label1);
        _content.add(label2);
        _content.add(text1);
        _content.add(text2);
        _content.add(SUBMIT);
        _content.add(PREVIOUS);

        this.setSize(1000,400);
        this.setResizable(false);
        this.setVisible(true);
        text1.requestFocusInWindow();
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            this.setVisible(false );
            System.exit(0);
        }

        if( ae.getSource() == minimize)
        {
            this.setState(this.ICONIFIED);
        }
        if( ae.getSource() == SUBMIT)
        {
            try
            {
                MrevellousPacker obj = new MrevellousPacker();
                this.dispose();
                NextPage t = new NextPage("MarevllousAdmin");
            }
            catch (Exception e){}
        }
        Object PREVIOUS;
                if( ae.getSource() == PREVIOUS)
        {
            this.setVisible(false);
            this.dispose();
            NextPage t = new NextPage("MarevllousAdmin");
        }
    }
} */