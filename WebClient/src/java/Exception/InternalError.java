/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 *
 * @author fokpoonkai
 */
public class InternalError extends UniformInterfaceException {
    
    public InternalError(ClientResponse r) {
        super(r);
    }
    
}
