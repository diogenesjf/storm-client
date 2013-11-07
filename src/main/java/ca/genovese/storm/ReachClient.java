package ca.genovese.storm;

import backtype.storm.utils.DRPCClient;

public class ReachClient {
    public static void main(String [] args) {
        DRPCClient drpcClient = new DRPCClient("ec2-184-73-53-145.compute-1.amazonaws.com", 3772, 500);

        System.out.println("Connected to rpc client - issue cmds now");

        try {
            String reach = drpcClient.execute("reach", "foo.com/blog/1");
            System.out.println("sent - foo.com/blog/1");

            System.out.println("\n\n\nReceived: " + reach);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            drpcClient.close();
        }
    }
}
