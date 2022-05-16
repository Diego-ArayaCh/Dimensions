
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * Tutorial para crear una ventana con bordes redondeados y transparentes en Java
 * @author s.labajos
 *
 */
public class VentanaRedondeada extends JWindow {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaRedondeada() {
		try {
			final BufferedImage fondo = ImageIO.read(new File("images/fondo.png"));
			contentPane = new JPanel(new BorderLayout()) {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2d = (Graphics2D) g.create();
					GraphicsConfiguration gc = g2d.getDeviceConfiguration();

					int width = fondo.getWidth();
					int height = fondo.getHeight();
					
					//generamos una imagen de bordes redondeados a partir de la imagen original
					BufferedImage img = gc.createCompatibleImage(width,height,Transparency.TRANSLUCENT);
					Graphics2D g2 = img.createGraphics();
					g2.setComposite(AlphaComposite.Clear);
					g2.fillRect(0, 0, width, height);
					g2.setComposite(AlphaComposite.Src);
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setColor(Color.WHITE);
					g2.fillRoundRect(0, 0, width, height, 20, 20);
					g2.setComposite(AlphaComposite.SrcAtop);
					g2.drawImage(fondo, 0, 0, null);
					g2.dispose();

					//pintamos la imagen que hemos generado
					g2d.drawImage(img, 0, 0, this);
					g2d.dispose();
				}
			};
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JLabel label = new JLabel("SalvatoreLab.es");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setForeground(Color.WHITE);
			contentPane.add(label, BorderLayout.CENTER);
			
			JButton btnAceptar = new JButton("");
			ImageIcon iconb = new ImageIcon("images/boton.png");
			btnAceptar.setBorderPainted(false);
			btnAceptar.setContentAreaFilled(false);
			btnAceptar.setFocusable(false);
			btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAceptar.setIcon(iconb);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(btnAceptar, BorderLayout.SOUTH);
			
			contentPane.setDoubleBuffered(false);
			contentPane.setOpaque(false);
			this.setLayout(new BorderLayout());
			this.add(contentPane, BorderLayout.CENTER);
			this.setSize(300,150);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			com.sun.awt.AWTUtilities.setWindowOpaque(this, false);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaRedondeada();
			}
		});
	}

}
