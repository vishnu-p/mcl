/**
 * 
 */
package com.mcl.backend.core.persistence.dao;

import java.io.Serializable;
import java.util.List;

import com.mcl.backend.core.persistence.model.client.UserAccount;

/**
 * 
 * 
 * @author vishnu-p
 *
 */
public interface UserAccountDao extends GenericDao<UserAccount, Serializable> {
	
	public UserAccount get(Long userId);
	
	public UserAccount getUserAccountByUsername(String username);
	
	public UserAccount getUserAccount(String username, String password);	
	
	public boolean isUserExists(String username);	
	
	List<UserAccount> getUserAccounts(Long userId, String firstName, String lastName);

}
