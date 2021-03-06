package chainOfResponsability;
public class Handler1 implements HandlerInterface{
    HandlerInterface sucessor;
    String handlerType;
    public Handler1(HandlerInterface sucessor) {
        this.sucessor=sucessor;
        this.handlerType=RequestType.Type1.toString();
    }
    @Override
    public void handleRequest(RequestInterface request) {
        if(request.getType().equals(handlerType)){
            System.out.println("Congratulations! Your request has been successfully handled by "+this.getClass().getSimpleName());
        } else{
            System.out.println("Sorry! "+this.getClass().getSimpleName()+" unable to handle the request. Sending it to another handler...");
            sucessor.handleRequest(request);
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
