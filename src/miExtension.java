import com.smartfoxserver.v2.extensions.SFSExtension;


public class miExtension extends SFSExtension{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		//System.out.println("It works");
		this.addRequestHandler("ver", solicitudHandler.class);
		this.addRequestHandler("insert", miHandler.class);
		this.addRequestHandler("arantxa", miHandler.class);
		//this.addRequestHandler(requestId, theClass)
	}

}
