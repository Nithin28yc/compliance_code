def call(Map params) 
{
   stage("Data at Rest&Transit- Transmission od data and Encryption of it")
   {
    
      container('maven') {
	
	sh'''
    	cd Compliance_Check
    	ls
    	pwd
    	# give the platform url with username and password
        mvn test -DsuiteXmlFile=TransmissionEncryptionOfData.xml
    '''
	}
						
        
    }
}

