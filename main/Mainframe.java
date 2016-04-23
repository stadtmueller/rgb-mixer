package de.stadtmueller.rgbmixer;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;


public class Mainframe extends JFrame
{
	private static final long serialVersionUID = 7888194461715698140L;

	private Color resultColor = new Color( 0, 0, 0 );
	
	private JPanel resultColorPanel;
	
	private JPanel contentPane;
	private JTextField redTextField;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JTextField greenTextField;
	private JSlider blueSlider;
	private JTextField blueTextField;
	private JLabel hexLabel;
	private JLabel rgbLabel;
	
	private ColorPreview preview = new ColorPreview();

	public static void main( String[] args )
	{
		EventQueue.invokeLater( new Runnable()
		{
			public void run()
			{
				try
				{
					Mainframe frame = new Mainframe();
					frame.setVisible( true );
				} catch( Exception e )
				{
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the frame.
	 */
	private void updateValues()
	{
		resultColorPanel.setBackground( resultColor );
		
		redTextField.setText( String.valueOf( resultColor.getRed() ) );
		redSlider.setValue( resultColor.getRed() );
		
		greenTextField.setText( String.valueOf( resultColor.getGreen() ) );
		greenSlider.setValue( resultColor.getGreen() );
		
		blueTextField.setText( String.valueOf( resultColor.getBlue() ) );
		blueSlider.setValue( resultColor.getBlue() );
		
		hexLabel.setText( String.format( "#%02X%02X%02X", resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue() ) );
		rgbLabel.setText( String.format( "RGB( %s, %s, %s )", resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue() ) );
	}
	
	private void updateLookAndFeel( UIManager.LookAndFeelInfo info )
	{
		try
		{
			UIManager.setLookAndFeel( info.getClassName() );
			SwingUtilities.updateComponentTreeUI( this );
		}
		catch( Exception ex )
		{
			System.out.println( ex.getClass().getSimpleName() );
		}
	}
	
	private void invertColor()
	{
		int newRed = 255 - resultColor.getRed();
		int newGreen = 255 - resultColor.getGreen();
		int newBlue = 255 - resultColor.getBlue();
		
		resultColor = new Color( newRed, newGreen, newBlue );
		updateValues();
	}
	
	public void copyHexToClipboard()
	{
		StringSelection stse = new StringSelection( hexLabel.getText() );
        Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
        board.setContents( stse, null );
	}
	
	public void copyRGBToClipboard()
	{
		StringSelection stse = new StringSelection( rgbLabel.getText() );
        Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
        board.setContents( stse, null );
	}
	
	public Mainframe()
	{
		setTitle( "RGB-Mixer - V3" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 871, 316 );
		//setResizable( false );
		
		//
		//	-------------------------- Init the menubar -------------------------------------------
		//
		
		
		// The menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		
		
		// The file menu
		JMenu file = new JMenu( "File" );
		menuBar.add( file );
		
		// Copy menu items
		JMenuItem copyRGBNotation = new JMenuItem( "Copy RGB-Notation" );
		copyRGBNotation.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				copyRGBToClipboard();
			}
		} );
		file.add( copyRGBNotation );
		
		JMenuItem copyHexNotation = new JMenuItem( "Copy Hex-Notation" );
		copyHexNotation.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				copyHexToClipboard();
			}
		});
		file.add( copyHexNotation );
		
		// Separator
		file.addSeparator();
		
		// Color operations
		JMenuItem brighterColorMenuItem = new JMenuItem( "Brighter" );
		brighterColorMenuItem.addActionListener( new ActionListener()
		{	
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = resultColor.brighter();
				updateValues();
			}
		});
		file.add( brighterColorMenuItem );
		
		JMenuItem darkerColorMenuItem = new JMenuItem( "Darker" );
		darkerColorMenuItem.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = resultColor.darker();
				updateValues();
			}
		});
		file.add( darkerColorMenuItem );
		
		JMenuItem invertColorMenuItem = new JMenuItem( "Invert Color" );
		invertColorMenuItem.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				invertColor();		
			}
		} );
		file.add( invertColorMenuItem );
		
		JMenuItem previewMenuItem = new JMenuItem( "Preview" );
		previewMenuItem.addActionListener( new ActionListener()
		{	
			@Override
			public void actionPerformed( ActionEvent e )
			{
				preview.setPreviewColor( resultColor );
				preview.setVisible( true, UIManager.getLookAndFeel() );
			}
		});
		file.add( previewMenuItem );
		
		// Separator
		file.addSeparator();
		
		// Presets
		JMenuItem redColorMenuItem = new JMenuItem( "Red" );
		redColorMenuItem.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.red;
				updateValues();
			}
		});
		file.add( redColorMenuItem );
		
		JMenuItem greenColorMenuItem = new JMenuItem( "Green" );
		greenColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.green;
				updateValues();
			}
		});
		file.add( greenColorMenuItem );
		
		JMenuItem blueColorMenuItem = new JMenuItem( "Blue" );
		blueColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.blue;
				updateValues();
			}
		});
		file.add( blueColorMenuItem );
		
		JMenuItem blackColorMenuItem = new JMenuItem( "Black" );
		blackColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.black;
				updateValues();
			}
		});
		file.add( blackColorMenuItem );
		
		JMenuItem whiteColorMenuItem = new JMenuItem( "White" );
		whiteColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.white;
				updateValues();
			}
		});
		file.add( whiteColorMenuItem );
		
		JMenuItem cyanColorMenuItem = new JMenuItem( "Cyan" );
		cyanColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.cyan;
				updateValues();
			}
		});
		file.add( cyanColorMenuItem );
		
		JMenuItem magentaColorMenuItem = new JMenuItem( "Magenta" );
		magentaColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.magenta;
				updateValues();
			}
		});
		file.add( magentaColorMenuItem );
		
		JMenuItem yellowColorMenuItem = new JMenuItem( "Yellow" );
		yellowColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.yellow;
				updateValues();
			}
		});
		file.add( yellowColorMenuItem );
		
		JMenuItem darkGrayColorMenuItem = new JMenuItem( "Dark gray" );
		darkGrayColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.darkGray;
				updateValues();
			}
		});
		file.add( darkGrayColorMenuItem );
		
		JMenuItem grayColorMenuItem = new JMenuItem( "Gray" );
		grayColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.gray;
				updateValues();
			}
		});
		file.add( grayColorMenuItem );
		
		JMenuItem lightGrayColorMenuItem = new JMenuItem( "Light Gray" );
		lightGrayColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.lightGray;
				updateValues();
			}
		});
		file.add( lightGrayColorMenuItem );
		
		JMenuItem orangeColorMenuItem = new JMenuItem( "Orange" );
		orangeColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.orange;
				updateValues();
			}
		});
		file.add( orangeColorMenuItem );
		
		JMenuItem pinkColorMenuItem = new JMenuItem( "Pink" );
		pinkColorMenuItem.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed( ActionEvent e )
			{
				resultColor = Color.pink;
				updateValues();
			}
		});
		file.add( pinkColorMenuItem );
		
		// Separator
		file.addSeparator();
		
		// Exit
		JMenuItem exitMenuItem = new JMenuItem( "Exit" );
		exitMenuItem.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				System.exit( 0 );
			}
		} );
		file.add( exitMenuItem );
		
		
		// The appearance menu
		JMenu appearance = new JMenu( "Appearance" );
		menuBar.add( appearance );
		
		JMenuItem item;
		
		for( UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() )
		{
			item = new JMenuItem( info.getName() );
			item.addActionListener( new ActionListener()
			{
				@Override
				public void actionPerformed( ActionEvent e )
				{
					updateLookAndFeel( info );
				}
			});
			appearance.add( item );
		}
		
		
		// The About menu
		JMenu about = new JMenu( "About" );
		menuBar.add( about );
		
		JMenuItem versionMenuEntry = new JMenuItem( "Version" );
		versionMenuEntry.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				JOptionPane.showMessageDialog( null, "RGB-Mixer - V3\nA color mixing tool writen in Java", "Version", JOptionPane.INFORMATION_MESSAGE );
			}
		});
		about.add( versionMenuEntry );
		
		
		//
		// ---------------------------------- Done: Init menubar ---------------------------------------
		//
		
		
		redTextField = new JTextField();
		redTextField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int val;
				
				try
				{
					val = Integer.parseInt( redTextField.getText() );
				}
				catch( NumberFormatException redNumberException )
				{
					val = resultColor.getRed();
				}
				
				if( val > 255 )
					val = 255;
				else if( val < 0 )
					val = 0;
				
				resultColor = new Color( val, resultColor.getGreen(), resultColor.getBlue() );
				updateValues();
			}
		});
		redTextField.setBounds(10, 195, 100, 27);
		redTextField.setColumns(3);
		
		redSlider = new JSlider();
		redSlider.setBounds(10, 11, 34, 178);
		redSlider.setMaximum(255);
		redSlider.setValue( 0 );
		redSlider.setOrientation(SwingConstants.VERTICAL);
		redSlider.addChangeListener( new ChangeListener()
		{
			@Override
			public void stateChanged( ChangeEvent e )
			{
				resultColor = new Color( redSlider.getValue(), resultColor.getGreen(), resultColor.getBlue() );
				updateValues();
			}
		} );
		
		JPanel redPanel = new JPanel();
		redPanel.setBounds(45, 11, 65, 178);
		redPanel.setBackground( Color.red );
		redPanel.setBorder( BorderFactory.createLineBorder( Color.black ) );
		
		JButton redPlusButton = new JButton("+");
		redPlusButton.setBounds(10, 228, 45, 30);
		redPlusButton.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				if( resultColor.getRed() == 255 )
					return;
				else
					resultColor = new Color( resultColor.getRed() + 1, resultColor.getGreen(), resultColor.getBlue() );
					
				updateValues();
			}
		} );
		
		JButton redMinusButton = new JButton("-");
		redMinusButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if( resultColor.getRed() == 0 )
					return;
				else
					resultColor = new Color( resultColor.getRed() - 1, resultColor.getGreen(), resultColor.getBlue() );
				
				updateValues();
			}
		});
		redMinusButton.setBounds(65, 228, 45, 30);
		
		greenSlider = new JSlider();
		greenSlider.setValue( 0 );
		greenSlider.setBounds(129, 11, 34, 178);
		greenSlider.setOrientation(SwingConstants.VERTICAL);
		greenSlider.setMaximum( 255 );
		greenSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				resultColor = new Color( resultColor.getRed(), greenSlider.getValue(), resultColor.getBlue() );
				updateValues();
			}
		});
		
		greenTextField = new JTextField();
		greenTextField.setBounds(130, 195, 100, 27);
		greenTextField.setColumns(3);
		greenTextField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int val;
				
				try
				{
					val = Integer.parseInt( greenTextField.getText() );
				}
				catch( NumberFormatException greenNumberException )
				{
					val = resultColor.getGreen();
				}
				
				if( val > 255 )
					val = 255;
				else if( val < 0 )
					val = 0;
				
				resultColor = new Color( resultColor.getRed(), val, resultColor.getBlue() );
				updateValues();
			}
		});
		
		JButton greenPlusButton = new JButton("+");
		greenPlusButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if( resultColor.getGreen() == 255 )
					return;
				else
					resultColor = new Color( resultColor.getRed(), resultColor.getGreen() + 1, resultColor.getBlue() );
					
				updateValues();
			}
		});
		greenPlusButton.setBounds(130, 228, 45, 30);
		
		JButton greenMinusButton = new JButton("-");
		greenMinusButton.setBounds(185, 228, 45, 30);
		greenMinusButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if( resultColor.getGreen() == 0 )
					return;
				else
					resultColor = new Color( resultColor.getRed(), resultColor.getGreen() - 1, resultColor.getBlue() );
				
				updateValues();
			}
		});
		
		JPanel greenPanel = new JPanel();
		greenPanel.setBounds(165, 11, 65, 178);
		greenPanel.setBackground( Color.green );
		greenPanel.setBorder( BorderFactory.createLineBorder( Color.black ) );
		
		blueSlider = new JSlider();
		blueSlider.setBounds(250, 11, 34, 178);
		blueSlider.setOrientation(SwingConstants.VERTICAL);
		blueSlider.setMaximum( 255 );
		blueSlider.setValue( 0 );
		blueSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				resultColor = new Color( resultColor.getRed(), resultColor.getGreen(), blueSlider.getValue() );
				updateValues();
			}
		});
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBounds(285, 11, 65, 178);
		bluePanel.setBackground( Color.blue );
		bluePanel.setBorder( BorderFactory.createLineBorder( Color.black ) );
		contentPane.setLayout(null);
		contentPane.add(redSlider);
		contentPane.add(redPanel);
		contentPane.add(redTextField);
		contentPane.add(redPlusButton);
		contentPane.add(redMinusButton);
		contentPane.add(greenPlusButton);
		contentPane.add(greenMinusButton);
		contentPane.add(greenTextField);
		contentPane.add(greenSlider);
		contentPane.add(greenPanel);
		contentPane.add(blueSlider);
		contentPane.add(bluePanel);
		
		blueTextField = new JTextField();
		blueTextField.setBounds(250, 195, 100, 27);
		contentPane.add(blueTextField);
		blueTextField.setColumns(3);
		blueTextField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				int val;
				
				try
				{
					val = Integer.parseInt( blueTextField.getText() );
				}
				catch( NumberFormatException greenNumberException )
				{
					val = resultColor.getBlue();
				}
				
				if( val > 255 )
					val = 255;
				else if( val < 0 )
					val = 0;
				
				resultColor = new Color( resultColor.getRed(), resultColor.getGreen(), val );
				updateValues();
			}
		});
		
		JButton bluePlusButton = new JButton("+");
		bluePlusButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if( resultColor.getBlue() == 255 )
					return;
				else
					resultColor = new Color( resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue() + 1 );
					
				updateValues();
			}
		});
		bluePlusButton.setBounds(250, 228, 45, 30);
		contentPane.add(bluePlusButton);
		
		JButton blueMinusButton = new JButton("-");
		blueMinusButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if( resultColor.getBlue() == 0 )
					return;
				else
					resultColor = new Color( resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue() - 1 );
				
				updateValues();
			}
		});
		blueMinusButton.setBounds(305, 228, 45, 30);
		contentPane.add(blueMinusButton);
		
		JLabel lblHex = new JLabel("Hex:");
		lblHex.setBounds(381, 11, 45, 27);
		contentPane.add(lblHex);
		
		JLabel lblRgb = new JLabel("RGB:");
		lblRgb.setBounds(381, 44, 45, 27);
		contentPane.add(lblRgb);
		
		hexLabel = new JLabel();
		hexLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		hexLabel.setBounds(438, 11, 134, 27);
		contentPane.add(hexLabel);
		
		rgbLabel = new JLabel();
		rgbLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		rgbLabel.setBounds(438, 44, 187, 27);
		contentPane.add(rgbLabel);
		
		JButton copyHexButton = new JButton("Copy");
		copyHexButton.setBounds(637, 11, 80, 27);
		copyHexButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				copyHexToClipboard();
			}
		});
		contentPane.add(copyHexButton);
		
		JButton copyRGBButton = new JButton("Copy");
		copyRGBButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				copyRGBToClipboard();
			}
		});
		copyRGBButton.setBounds(637, 44, 80, 27);
		contentPane.add(copyRGBButton);
		
		resultColorPanel = new JPanel();
		resultColorPanel.setBounds(381, 77, 336, 181);
		contentPane.add(resultColorPanel);
		resultColorPanel.setBackground( resultColor );
		resultColorPanel.setBorder( BorderFactory.createLineBorder( Color.black, 2 ) );
		
		JButton invertButton = new JButton("Invert");
		invertButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				invertColor();
			}
		});
		invertButton.setBounds(741, 77, 118, 27);
		contentPane.add(invertButton);
		
		JButton brighterButton = new JButton("Brighter");
		brighterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				resultColor = resultColor.brighter();
				updateValues();
			}
		});
		brighterButton.setBounds(741, 11, 118, 27);
		contentPane.add(brighterButton);
		
		JButton darkerButton = new JButton("Darker");
		darkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				resultColor = resultColor.darker();
				updateValues();
			}
		});
		darkerButton.setBounds(741, 44, 118, 27);
		contentPane.add(darkerButton);
		
		JButton previewButton = new JButton("Preview");
		previewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				preview.setPreviewColor( resultColor );
				preview.setVisible( true, UIManager.getLookAndFeel() );
			}
		});
		previewButton.setBounds(741, 110, 118, 27);
		contentPane.add(previewButton);
		
		JSeparator separatorRGBValues = new JSeparator();
		separatorRGBValues.setOrientation(SwingConstants.VERTICAL);
		separatorRGBValues.setBounds(362, 12, 15, 246);
		contentPane.add(separatorRGBValues);
		
		JSeparator separatorValuesControlls = new JSeparator();
		separatorValuesControlls.setOrientation(SwingConstants.VERTICAL);
		separatorValuesControlls.setBounds(729, 12, 15, 246);
		contentPane.add(separatorValuesControlls);
		
		// Initial update
		updateValues();
	}
}
