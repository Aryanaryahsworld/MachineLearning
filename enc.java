
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class enc {
    private PBEParameterSpec ps;
    	private PBEKeySpec ciperSpe;
       	private SecretKey secNum;
        private Cipher ciper;
        
        public void InitiateCipher(int Mode)
        {
            try
                {
                    ps = new PBEParameterSpec(Salt, Count);
                    ciperSpe = new PBEKeySpec("1234".toCharArray());
                   secNum = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(ciperSpe);
                   ciper = Cipher.getInstance("PBEWithMD5AndDES");
                   ciper.init(Mode, secNum, ps);
                 }
            catch(Throwable t) {t.printStackTrace();}
         }
        
        public void Encrypt(String path )
            {
                try
                    {
                    InitiateCipher(Cipher.ENCRYPT_MODE);
//                    fChoose.removeChoosableFileFilter(FilenameFilter.getInstance());
//                    fChoose.setSelectedFile(new File("*.*"));
//                     if(fChoose.showOpenDialog(new JFrame()) != JFileChooser.APPROVE_OPTION)
//                     return;
//                     String FileChosen = fChoose.getSelectedFile().getName();
                    File f=new File(path);
                     File f1=new File(path+"1");
                     BufferedInputStream In = new BufferedInputStream(new FileInputStream(f));
                   //  fChoose.addChoosableFileFilter(FilenameFilter.getInstance());
                    // fChoose.setSelectedFile(new File((FileChosen.indexOf(".") != -1 ? FileChosen.substring(0, FileChosen.indexOf(".")) : FileChosen) + ".manojf"));
                     //if(fChoose.showSaveDialog(new JFrame()) != JFileChooser.APPROVE_OPTION)
                    // return;
                     
                     CipherOutputStream Out = new CipherOutputStream(new FileOutputStream(f1), ciper);
                     int Buffer;
                     while ((Buffer = In.read()) != -1)
                     Out.write(Buffer);
                     Out.close();
                     In.close();
                     }
                     catch(Throwable t) {}
            }				                                                            				
                                                            	
            public void DAction(String path)
            {
              try
              {
              InitiateCipher(Cipher.DECRYPT_MODE);
             
             File f=new File(path);
             String str = path.substring(0, path.length()-1);
                     File f1=new File(str);
              CipherInputStream In = new CipherInputStream(new FileInputStream(f), ciper);
              
              BufferedOutputStream Out = new BufferedOutputStream(new FileOutputStream(f1));
              int Buffer;
              while ((Buffer = In.read()) != -1)
              Out.write(Buffer);
              Out.close();
              In.close();
              }
                catch(Throwable t) {}
            }

//private static class FilenameFilter extends FileFilter
//{
//    public boolean accept(File FileChosen)
//     {
//     return FileChosen.isDirectory() || FileChosen.getAbsolutePath().substring(FileChosen.getAbsolutePath().lastIndexOf(".")).equalsIgnoreCase(".manojf");
//     }
//     public String getDescription()
//       {
//     return "EncryptDecrypt Files (*.manojf)";
//       }
//          public static FilenameFilter getInstance()
//          {
//          return new FilenameFilter();
//          }
//}
      public final static int Count = 20;	
      public final static byte[] Salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c, (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
}

