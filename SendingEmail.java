import org.apache.commons.mail.*;

public class SendingEmail {
    public static void main(String[] args) {
        try {
            // Create the email with attachment
            MultiPartEmail email = createEmailWithAttachment();

            // Send the email
            for(int i =0; i<10; i++) {
                sendEmail(email);
            }

            System.out.println("Email sent successfully!");
        } catch (EmailException e) {
            e.printStackTrace();
            System.err.println("Error sending email: " + e.getMessage());
        }
    }

    private static MultiPartEmail createEmailWithAttachment() throws EmailException {
        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:\\Users\\Admin\\Desktop\\EmailSender\\src\\SendingEmailToDr.java");
        
        // We use this so that the file is sent as a file that can be downloaded, unlike the .INLINE which adds the files as a text. 
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        
        //Set the description of the file 
        attachment.setDescription("Java File of the Project");
        
        //Set the name of the file
        attachment.setName("SendingEmail Java File");

        // Create the email message that includes the message with the attachment
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");

        // Enable SSL for SMTP
        email.setSSLOnConnect(true);

        // Set SMTP port for SSL (use port 465)
        email.setSmtpPort(465);

        // Set Gmail credentials (user name and password)
        String username = "";
        
        // For privacy purposes, I have used encapsulation for the password  
        String password = SendingEmailReal.getPassCode();

        // From JavaMail API
        email.setAuthenticator(new DefaultAuthenticator(username, password));

        // Add recipient's and sender's information
        email.addTo("barackobama@gmail.com", "Barack Obama");  
        email.setFrom("YourEmail@gmail.com", "Your Name");
        
        // Set the email subject 
        email.setSubject("Sending an Email using the Apache Commons commons-email Library");
        
        // Set the message of the email 
        email.setMsg("");

        // Add the attachment
        email.attach(attachment);

        return email;
    }

    private static void sendEmail(MultiPartEmail email) throws EmailException {
        email.send();
    }
}
