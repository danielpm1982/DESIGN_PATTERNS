package command;
public class StereoOnCommand implements Command{
    private final Stereo stereo;
    private boolean wasTurnedOn;
    public StereoOnCommand(Stereo stereo) {
        this.stereo=stereo;
        this.wasTurnedOn=false;
    }
    @Override
    public void execute() {
        if(!stereo.hasMedia()){
            String lastMediaInside=stereo.getLastMediaInside();
            if(lastMediaInside!=null)
                stereo.insertMedia(lastMediaInside);
            else
                stereo.insertMedia(StereoMediaList.getRandomMediaName());
        }
        if(stereo.getLastVolume()!=0){
            stereo.setVolume(stereo.getLastVolume());
        } else{
            stereo.setVolume(10);
        }
        stereo.turnOn();
        wasTurnedOn=true;
    }
    @Override
    public void undo() {
        if(wasTurnedOn){
            if(stereo.hasMedia()){
                stereo.setLastMediaInside(stereo.getMedia());
                stereo.ejectMedia();
            }
            stereo.setLastVolume(stereo.getVolume());
            stereo.setVolume(0);
            stereo.turnOff();
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
