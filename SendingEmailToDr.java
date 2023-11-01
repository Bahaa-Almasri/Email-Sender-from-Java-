import org.apache.commons.mail.*;

public class SendingEmailToDr {
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
        attachment.setName("SendingEmailToDr Java File");

        // Create the email message that includes the message with the attachment
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");

        // Enable SSL for SMTP
        email.setSSLOnConnect(true);

        // Set SMTP port for SSL (use port 465)
        email.setSmtpPort(465);

        // Set Gmail credentials (user name and password)
        String username = "bahaaalmasri2005@gmail.com";
        
        // For privacy purposes, I have used encapsulation for the password  
        String password = SendingEmailToDrReal.getPassCode();

        // From JavaMail API
        email.setAuthenticator(new DefaultAuthenticator(username, password));

        // Add recipient's and sender's information
        email.addTo("barackobamaandme85@gmail.com", "Dr. Wissam Fawaz");  
        email.setFrom("bahaaalmasri2005@gmail.com", "Bahaa Almasri");
        
        // Set the email subject 
        email.setSubject("Sending an Email using the Apache Commons commons-email Library");
        
        // Set the message of the email 
        email.setMsg("Dear Dr. Wissam Fawaz,\r\n"
        		+ "\r\n"
        		+ "I hope this message finds you well and that you can spare a moment to read this brief note. \r\n"
        		+ "\r\n"
        		+ " My name is Bahaa Almasri, and I am currently a second-year computer engineering student. \r\n"
        		+ "\r\n"
        		+ "Over the past two years, I have not only achieved academic excellence, but also have dedicated myself to developing essential skill sets that I believe are crucial for a successful career in our field. In particular, I have focused on web development, communication skills, and leadership abilities.\r\n"
        		+ "\r\n"
        		+ "In the realm of web development, I have gained hands-on experience working with HTML, CSS, and JavaScript. I've had the opportunity to work on many projects, my 2 favorites being: \r\n"
        		+ " 1- A website for an event about Sustanable Energy between the United Kingdom and Mauritania that has been created but not published yet.\r\n"
        		+ " 2- A movie database website that I prepared to present in an upcoming event, that uses multiple APIs, this is the link if you want to check it out: https://moviedatabasex.000webhostapp.com/.\r\n"
        		+ "\r\n"
        		+ "Thank you for your time. I look forward to the content of this course and, more importantly, the knowledge and experience you enrich our class with.\r\n"
        		+ "\r\n"
        		+ "Please reply to this email so that I know it has been sent.\r\n"
        		+ "\r\n"
        		+ "Kindly find below the attached java code that I wrote to send you this email with the attachment.");

        // Add the attachment
        email.attach(attachment);

        return email;
    }

    private static void sendEmail(MultiPartEmail email) throws EmailException {
        email.send();
    }
}