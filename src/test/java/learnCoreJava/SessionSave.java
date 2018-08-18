package learnCoreJava;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SessionSave 
{
	private static final String URL = "url";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	static Preferences prefs = null;
	
	public static void main(String args[]) throws Exception
	{
		try
		{
			prefs = Preferences.userNodeForPackage(SessionSave.class);
		}
		catch(Exception e3){}
		
		final JFrame f = new JFrame("Credentials");
		f.setLayout(new GridLayout(4,2));
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		JLabel urlLabel = new JLabel("            URL : ");
		JLabel usernameLabel = new JLabel("Username : ");
		JLabel passwordLabel = new JLabel("Password : ");
		final JTextField urlTf = new JTextField(prefs.get("url", "default"), 30);
		final JTextField usernameTf = new JTextField(prefs.get("username", "default"), 30);
		final JPasswordField passwordTf = new JPasswordField(prefs.get("password", "default"), 30);
		
		JButton fetch = new JButton("Fetch");	
		fetch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String userUrl = urlTf.getText();
				String userUsername = usernameTf.getText();
				String userPassword = passwordTf.getText();				
				prefs.put("url", userUrl);
				prefs.put("username", userUsername);
				prefs.put("password", userPassword);
			}			
		});
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				f.setVisible(false);
				f.dispose();
			}	
		});
		
		p1.add(urlLabel);
		p1.add(urlTf);
		p2.add(usernameLabel);
		p2.add(usernameTf);
		p3.add(passwordLabel);
		p3.add(passwordTf);
		p4.add(fetch);
		p4.add(cancel);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);		
		int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = 500;
		int height = 200;		
		int x = (screenWidth-width)/2;
		int y = (screenHeight-height)/2;		
		f.setBounds(x,y,width,height);
		f.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*SessionSave s = new SessionSave();

		Variables v = new Variables();
		v.setUrl("my url");
		v.setUsername("my username");
		v.setPassword("my password");
		
		s.savePreference(v);
		
		
		
		System.out.println(s.readPreference().getUrl());
		System.out.println(s.readPreference().getUsername());
		System.out.println(s.readPreference().getPassword());*/
		
		
		System.out.println("Success");
		
	}
	
	public void savePreference(Variables v)
	{
        Preferences prefs = Preferences.userNodeForPackage(SessionSave.class);
        prefs.put(URL, v.getUrl());
        prefs.put(USERNAME, v.getUsername());
        prefs.put(PASSWORD, v.getPassword());
    }

    public Variables readPreference() 
    {
        Preferences prefs = Preferences.userNodeForPackage(SessionSave.class);
        Variables v = new Variables();
        v.setUrl(prefs.get(URL, "default"));
        v.setUsername(prefs.get(USERNAME, "default"));
        v.setPassword(prefs.get(PASSWORD, "default"));        
        return v;
    }
	
}


class Variables
{
	private String url;
	private String username;
	private String password;	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
