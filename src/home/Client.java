package home;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.HashMap;

import home.controls.BasketControl;
import home.controls.LoginControl;
import home.controls.SignUpControl;
import home.controls.TableControl;
import home.controls.UserInfoControl;
import home.fileController.CheckDuplication;
import home.fileController.FileTool;
import home.frameworks.BasketInterface;
import home.frameworks.CheckDuplicationInterface;
import home.frameworks.FileToolInterface;
import home.frameworks.Invoker;
import home.frameworks.LoginInterface;
import home.frameworks.SignUpInterface;
import home.frameworks.Stub;
import home.frameworks.TableInterface;
import home.frameworks.UserInfoInterface;

public class Client implements Serializable {
    private Socket client;
    private InputStream inputStream;
    private OutputStream outputStream;

    public Client(Socket client) {
        try {
            this.client = client;
            this.inputStream = this.client.getInputStream();
            this.outputStream = this.client.getOutputStream();
            this.initializeObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeObject() {
    	// Key, Value ¿˙¿Â
    	HashMap<String, Stub> stubTable = new HashMap<>();
        BasketInterface basketInterface = new BasketControl();
        CheckDuplicationInterface checkDuplicationInterface = new CheckDuplication();
        FileToolInterface fileToolInterface = new FileTool();
        LoginInterface loginInterface = new LoginControl();
        SignUpInterface signUpInterface = new SignUpControl();
        TableInterface tableInterface = new TableControl();
        UserInfoInterface userInfoInterface = new UserInfoControl();
        
        stubTable.put("BasketInterface", basketInterface);
        stubTable.put("CheckDuplicationInterface", checkDuplicationInterface);
        stubTable.put("FileToolInterface", fileToolInterface);
        stubTable.put("LoginInterface", loginInterface);
        stubTable.put("SignUpInterface", signUpInterface);
        stubTable.put("TableInterface", tableInterface);
        stubTable.put("UserInfoInterface", userInfoInterface);
        
        boolean communicate = true;
        try {
            while (communicate) {
                ObjectInputStream inputStream = new ObjectInputStream(this.inputStream);
                Object object = inputStream.readObject();
                if (object != null) {
                    if (object.equals("exit")) communicate = false;
                    else {
                        Object returnObject = null;
                        if (object instanceof Invoker) {
                            Invoker invoker = (Invoker) object;
                            Stub stub = stubTable.get(invoker.getClassName());
                            try {
                            	returnObject = stub.getClass().getMethod(invoker.getMethodName(), invoker.getParameterTypes()).invoke(stub, invoker.getParameters());
                            } catch (InvocationTargetException e) {
                                returnObject = e;
                            } catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        }
                        ObjectOutputStream output = new ObjectOutputStream(outputStream);
                        output.writeObject(returnObject);
                    }
                }
            }
        } catch (IOException | IllegalAccessException | ClassNotFoundException ignored) {
        }
    }

}
