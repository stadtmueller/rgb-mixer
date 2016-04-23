package de.stadtmueller.rgbmixer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class ColorPreview extends JFrame
{
	private static final long serialVersionUID = -7754153353595636207L;
	
	private JPanel contentPane;
	private Color previewColor;
	private JButton exitButton;
	private JPanel colorPanel;
	
	public void setPreviewColor( Color newColor )
	{
		this.previewColor = newColor;
		colorPanel.setBackground( this.previewColor );
	}
	
	public ColorPreview()
	{
		
		setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
		setBounds( 100, 100, 850, 450 );
		
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][][][][][][]", "[grow][][][][][][][][][][][][][][][]"));
		
		colorPanel = new JPanel();
		contentPane.add(colorPanel, "cell 0 0 20 14,grow");
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible( false );
			}
		});
		contentPane.add(exitButton, "cell 18 15");
	}
	
	public void setVisible( boolean b, LookAndFeel lookAndFeel )
	{
		super.setVisible( b );
		
		try
		{
			UIManager.setLookAndFeel( lookAndFeel );
			SwingUtilities.updateComponentTreeUI( this );
		}
		catch( Exception e )
		{
			System.out.println( "Exception @ setVisible from ColorPreview: " + e.getClass().getSimpleName() );
		}
	}

}
