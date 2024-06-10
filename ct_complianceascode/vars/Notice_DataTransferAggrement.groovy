def call(Map params) 
{
   stage("Notice- Data transfer aggrement")
   {
    
      container('maven') {
		withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'nithinyc',
        usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) 
     {
	sh'''
    	cd Compliance_Check
    	ls
    	pwd
    	# give the platform url with username and password
    	mvn test -DappURL="https://qemainlatest.continuoustestplatform.com/" -Dusername="ethanadmin" -Dpassword="D8SYqKRmcC4dn8Am38" -DenterpriseID="nithin.y.c@accenture.com" -DenterprisePassword=$PASSWORD -DsuiteXmlFile=DataTransfer_Policy.xml
	 '''
     }
	 	  withCredentials([usernamePassword(credentialsId: 'NEXUS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
				  sh '''
				  cd "$PWD"/test-output
				  mv LatestTestReportchromereport.html DataTransferAggrement.html
				  curl --upload-file DataTransferAggrement.html -u $USERNAME:$PASSWORD -v https://qemainlatest.continuoustestplatform.com/nexus/repository/Compliance/${JOB_NAME}/$BUILD_ID/
				  sleep 30
				  '''
				}
	}
						
        
    }
}

