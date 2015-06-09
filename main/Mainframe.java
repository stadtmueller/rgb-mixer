import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

public class Mainframe extends JFrame
{

    int red = 0;
    int green = 0;
    int blue = 0;
    Color color = new Color( red, green, blue );

    public Mainframe()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents()
    {

        jPanel1 = new JPanel();
        headLabel = new JLabel();
        redPlusButton = new JButton();
        redMinusButton = new JButton();
        redTextField = new JTextField();
        greenPlusButton = new JButton();
        greenMinusButton = new JButton();
        greenTextField = new JTextField();
        bluePlusButton = new JButton();
        blueMinusButton = new JButton();
        blueTextField = new JTextField();
        redPanel = new JPanel();
        bluePanel = new JPanel();
        greenPanel = new JPanel();
        resultColorPanel = new JPanel();
        copyButton = new JButton();
        blueSlider = new JSlider();
        greenSlider = new JSlider();
        redSlider = new JSlider();
        jSeparator1 = new JSeparator();
        exitButton = new JButton();
        copyHexButton = new JButton();

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("RGB-Mixer");

        headLabel.setFont(new Font("Ubuntu", 0, 20)); // NOI18N
        headLabel.setText("RGB-Mixer");

        redPlusButton.setText("+");
        redPlusButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                redPlusButtonActionPerformed(evt);
            }
        });

        redMinusButton.setText("-");
        redMinusButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                redMinusButtonActionPerformed(evt);
            }
        });

        redTextField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                redTextFieldActionPerformed(evt);
            }
        });

        greenPlusButton.setText("+");
        greenPlusButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                greenPlusButtonActionPerformed(evt);
            }
        });

        greenMinusButton.setText("-");
        greenMinusButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                greenMinusButtonActionPerformed(evt);
            }
        });

        greenTextField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                greenTextFieldActionPerformed(evt);
            }
        });

        bluePlusButton.setText("+");
        bluePlusButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                bluePlusButtonActionPerformed(evt);
            }
        });

        blueMinusButton.setText("-");
        blueMinusButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                blueMinusButtonActionPerformed(evt);
            }
        });

        blueTextField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                blueTextFieldActionPerformed(evt);
            }
        });

        redPanel.setBackground( Color.red );
        redPanel.setBorder( BorderFactory.createLineBorder( Color.black ));

        GroupLayout redPanelLayout = new GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        bluePanel.setBackground( Color.blue );
        bluePanel.setBorder( BorderFactory.createLineBorder( Color.black));

        GroupLayout bluePanelLayout = new GroupLayout(bluePanel);
        bluePanel.setLayout(bluePanelLayout);
        bluePanelLayout.setHorizontalGroup(
            bluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        bluePanelLayout.setVerticalGroup(
            bluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        greenPanel.setBackground( Color.green );
        greenPanel.setBorder( BorderFactory.createLineBorder( Color.black ));

        GroupLayout greenPanelLayout = new GroupLayout(greenPanel);
        greenPanel.setLayout(greenPanelLayout);
        greenPanelLayout.setHorizontalGroup(
            greenPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );
        greenPanelLayout.setVerticalGroup(
            greenPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        resultColorPanel.setBackground( color );
        resultColorPanel.setBorder( BorderFactory.createLineBorder( Color.black ));

        GroupLayout resultColorPanelLayout = new GroupLayout(resultColorPanel);
        resultColorPanel.setLayout(resultColorPanelLayout);
        resultColorPanelLayout.setHorizontalGroup(
            resultColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        resultColorPanelLayout.setVerticalGroup(
            resultColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        copyButton.setText("Copy RGB-Notation");
        copyButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                copyButtonActionPerformed(evt);
            }
        });

        blueSlider.setMaximum(255);
        blueSlider.setOrientation(JSlider.VERTICAL);
        blueSlider.setValue(0);
        blueSlider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent evt)
            {
                blueSliderStateChanged(evt);
            }
        });

        greenSlider.setMaximum(255);
        greenSlider.setOrientation(JSlider.VERTICAL);
        greenSlider.setValue(0);
        greenSlider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent evt)
            {
                greenSliderStateChanged(evt);
            }
        });

        redSlider.setMaximum(255);
        redSlider.setOrientation(JSlider.VERTICAL);
        redSlider.setValue(0);
        redSlider.addChangeListener(new ChangeListener()
        {
            public void stateChanged( ChangeEvent evt)
            {
                redSliderStateChanged(evt);
            }
        });

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        exitButton.setText("Exit");
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                exitButtonActionPerformed(evt);
            }
        });

        copyHexButton.setText("Copy Hex-Notation");
        copyHexButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                copyHexButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(headLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(redSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(redPlusButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redMinusButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addComponent(redTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                            .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(greenSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(greenPlusButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greenMinusButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addComponent(greenTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                            .addComponent(greenPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(blueSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bluePlusButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blueMinusButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addComponent(blueTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                            .addComponent(bluePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(copyButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(copyHexButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                    .addComponent(resultColorPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(resultColorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(copyButton)
                            .addComponent(exitButton)
                            .addComponent(copyHexButton)))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(redTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(redMinusButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(redPlusButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(greenPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(greenTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(greenPlusButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(greenMinusButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(blueSlider, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(greenSlider, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bluePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(bluePlusButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(blueMinusButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(redSlider, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        redMinusButton.getAccessibleContext().setAccessibleName("redMinusButton");

        pack();
    }
    
    private void redMinusButtonActionPerformed(ActionEvent evt)                                               
    {                                                   
        if (red > -1)
        {
            --red;
        } 
        else
        {
            red = 0;
        }
        redTextField.setText( String.valueOf( red ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        redSlider.setValue( red );
    }                                              

    private void redPlusButtonActionPerformed(ActionEvent evt)                                              
    {                                                  
        if (red < 255)
        {
            ++red;
        } else
        {
            red = 255;
        }
        redTextField.setText( String.valueOf( red ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        redSlider.setValue( red );
    }                                             

    private void greenPlusButtonActionPerformed(ActionEvent evt)                                                
    {                                                    
        if( green < 255 )
            ++green;
        else
            green = 255;
        greenTextField.setText( String.valueOf( green ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        greenSlider.setValue( green );
    }                                               

    private void redTextFieldActionPerformed(ActionEvent evt)                                             
    {                                                 
        int input = Integer.parseInt( redTextField.getText() );
        if( input <= 255 && input >= 0 )
            red = input;
        else if( input < 0 )
            red = 0;
        else if( input > 255 )
            red = 255;
        redTextField.setText( String.valueOf( red ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        redSlider.setValue( red );
    }                                            

    private void greenTextFieldActionPerformed(ActionEvent evt)                                               
    {                                                   
        int input = Integer.parseInt( greenTextField.getText() );
        if( input <= 255 && input >= 0 )
            green = input;
        else if( input < 0 )
            green = 0;
        else if( input > 255 )
            green = 255;
        greenTextField.setText( String.valueOf( green ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        greenSlider.setValue( green );
    }                                              

    private void blueTextFieldActionPerformed(ActionEvent evt)                                              
    {                                                  
        int input = Integer.parseInt( blueTextField.getText() );
        if( input <= 255 && input >= 0 )
            blue = input;
        else if( input < 0 )
            blue = 0;
        else if( input > 255 )
            blue = 255;
        blueTextField.setText( String.valueOf( blue ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        blueSlider.setValue( blue );
    }                                             

    private void greenMinusButtonActionPerformed(ActionEvent evt)                                                 
    {                                                     
        if( green > 0 )
            --green;
        else
            green = 0;
        greenTextField.setText( String.valueOf( green ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        greenSlider.setValue( green );
    }                                                

    private void bluePlusButtonActionPerformed(ActionEvent evt)                                               
    {                                                   
        if( blue < 255 )
            ++blue;
        else
            blue = 255;
        blueTextField.setText( String.valueOf( blue ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        blueSlider.setValue( blue );
    }                                              

    private void blueMinusButtonActionPerformed(ActionEvent evt)                                                
    {                                                    
        if( blue > 0 )
            --blue;
        else
            blue = 0;
        blueTextField.setText( String.valueOf( blue ) );
        color = new Color( red, green, blue );
        resultColorPanel.setBackground( color );
        blueSlider.setValue( blue );
    }                                               

    private void copyButtonActionPerformed(ActionEvent evt)                                           
    {                                               
        String s = String.valueOf( "rgb( " + red + ", " + green + ", " + blue + " );" );
        System.out.println( s );
        StringSelection stse = new StringSelection( s );
        Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
        board.setContents( stse, null );
    }                                          

    private void blueSliderStateChanged(ChangeEvent evt)                                        
    {                                            
            blue = blueSlider.getValue();
            color = new Color( red, green, blue );
            blueTextField.setText( String.valueOf( blue ) );
            resultColorPanel.setBackground( color );
    }                                       

    private void greenSliderStateChanged(ChangeEvent evt)                                         
    {                                             
            green = greenSlider.getValue();
            color = new Color( red, green, blue );
            greenTextField.setText( String.valueOf( green ) );
            resultColorPanel.setBackground( color );
    }                                        

    private void redSliderStateChanged(ChangeEvent evt)                                       
    {                                           
        red = redSlider.getValue();
        color = new Color( red, green, blue );
        redTextField.setText( String.valueOf( red ) );
        resultColorPanel.setBackground( color );
    }                                      

    private void exitButtonActionPerformed(ActionEvent evt)                                           
    {                                               
        int reply = JOptionPane.showConfirmDialog( null,"Do you want to quit the program?", "Exit", JOptionPane.YES_NO_OPTION  );
        if( reply == JOptionPane.YES_OPTION )
            System.exit( 0 );
    }                                          

    private void copyHexButtonActionPerformed(ActionEvent evt)                                              
    {                                                  
        String s = String.format( "#%02X%02X%02X", red, green, blue );
        StringSelection stse = new StringSelection( s );
        Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
        board.setContents( stse, null );
        
    }                                             

    public static void main(String args[])
    {
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Mainframe().setVisible(true);
            }
        });
    }

    private JButton blueMinusButton;
    private JPanel bluePanel;
    private JButton bluePlusButton;
    private JSlider blueSlider;
    private JTextField blueTextField;
    private JButton copyButton;
    private JButton copyHexButton;
    private JButton exitButton;
    private JButton greenMinusButton;
    private JPanel greenPanel;
    private JButton greenPlusButton;
    private JSlider greenSlider;
    private JTextField greenTextField;
    private JLabel headLabel;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private JButton redMinusButton;
    private JPanel redPanel;
    private JButton redPlusButton;
    private JSlider redSlider;
    private JTextField redTextField;
    private JPanel resultColorPanel;
}
