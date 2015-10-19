package sample24;

public class SampleUserList2 {
	
	private SampleUserList sample = new SampleUserList();
	public boolean login(String name, String password)
	throws SampleException3{
		try {
			return sample.login(name, password);
		} catch (SampleException e){
			throw new SampleException3(e);
		} catch (SampleException2 e){
			throw new SampleException3(e);
		}
	}

}
