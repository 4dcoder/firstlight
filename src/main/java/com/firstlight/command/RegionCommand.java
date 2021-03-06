package com.firstlight.command;

import org.jrebirth.core.command.DefaultUIBeanCommand;
import org.jrebirth.core.ui.Model;
import org.jrebirth.core.wave.Wave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.firstlight.service.RegionService;
import com.firstlight.wave.RegionAction;
import com.firstlight.wave.RegionWaveBean;
import com.firstlight.wave.WalletWaveBean;

/**
 * The class <strong>RegionCommand</strong>.
 * 
 * @author MrMoneyChanger
 */
public class RegionCommand extends DefaultUIBeanCommand<RegionWaveBean> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(RegionCommand.class);

    
    @Override
    public void ready() throws org.jrebirth.core.exception.CoreException {
    	super.ready();
    	
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void execute(final Wave wave) {

        final RegionService rs = getService(RegionService.class);

        LOGGER.info("Trigger stage action " + getWaveBean(wave).getAction());

        switch (getWaveBean(wave).getAction()) {
            case show:
            	rs.doShowRegion(wave);
                break;
            case hide:
            	rs.doHideRegion(wave);
                break;
            case register:
            	rs.doRegisterRegion(wave);
            	break;
            case unregister:
            	rs.doUnregisterRegion(wave);
            	break;
            default:
                LOGGER.error("Undefined RegionAction");
        }

    }

    /**
     * Get the wave bean and cast it.
     * 
     * @param wave the wave that hold the bean
     * 
     * @return the casted wave bean
     */
    @Override
    public RegionWaveBean getWaveBean(final Wave wave) {
        return (RegionWaveBean) wave.getWaveBean();
    }
    
    @Override
    protected void processWave(Wave wave) {
    	// TODO Auto-generated method stub
    	super.processWave(wave);
    	
    	
    }
    
    
    
}
