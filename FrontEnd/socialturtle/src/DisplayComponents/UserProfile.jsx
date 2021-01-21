import React, {useState} from 'react';
import {  MDBRow,  MDBCard, MDBCardBody, MDBIcon, MDBCol, MDBCardTitle, MDBBtn} from "mdbreact";
import { useSelector, useDispatch} from 'react-redux';
import { uploadFile } from 'react-s3';
import S3FileUpload from 'react-s3';
import axios from "axios";
import { v4 as uuidv4 } from 'uuid';
import ProfilePictureSuccess from '../Alerts/ProfilePictureSuccess'
import '../CSS/profile.css'

const UserProfile = () => {
    const currentUser = JSON.parse(localStorage.getItem('UserLocal'));
    const [selectedFile, setSelectedFile] = useState(null);
    const [profileImg, setProfileImg] = useState(currentUser.profileImg)
    const [profileSuccessAlert, showSuccessAlert] = useState(false)
    let key = ''
    let uploadUrl = ''

    //You will need to provide your own AWS S3 credentials
    const config = {
        bucketName: '',
        dirName: '', /* optional */
        region: '',
        accessKeyId: '',
        secretAccessKey: '',
    }

    const user = useSelector(state => state.LocalUser);

    function uploadPicture(e) {
      showSuccessAlert(false)
      let file = e.target.files[0];
      let blob = file.slice(0, file.size, file.type); 
      let newFile = new File([blob], uuidv4());
      console.log("new file: ", newFile)
      console.log("e: ",e)
      console.log("e.target: ",e.target.files)
      e.target.name = uuidv4();
        console.log(e.target.files[0])
        uploadFile( newFile, config)
        .then( (data)=> {
            console.log("data: ", data);
            let profilePicLocation = data.location;
            console.log("profile pic location: ",profilePicLocation)
            axios.post('http://localhost:9005/Project2/socialmedia/insertUserImage', {
              userId: currentUser.userId,
              profileImg: profilePicLocation
            })
            .then(function (response) 
            {
              console.log(response.status);
              if(response.status === 200) {
                console.log("success. trying to change local storage now...")
                console.log("profile image: ",profilePicLocation)
                console.log("current users profile")
               // localStorage.setItem('UserLocal.profileImg',profilePicLocation)
                localStorage.removeItem("UserLocal")
                currentUser.profileImg = profilePicLocation
                localStorage.setItem('UserLocal', JSON.stringify(currentUser))
                setProfileImg(profilePicLocation)
                showSuccessAlert(true)
              }
              }
            )
        })
        .catch( (err)=>{
           alert(err) 
        })
      .catch(err => console.error(err))
    }

    return (
        <div className="fade-in">   
             <MDBCard
          className='card-image' id='profile-background'
          style={{
            backgroundImage:
              "url('https://i.redd.it/kbhxfkobabf11.png')",
            objectFit: "cover"
          }}
        >
          <div className='text-white text-center d-flex justify-content-center rgba-black-strong py-5 px-4'>
            <div>
              <h5 id="profile-header">
              <MDBIcon icon="user" /> {currentUser.userName}
              </h5>
              <MDBCardTitle tag='h3' className='pt-2'>
                <strong className="mr-2">{currentUser.firstname} {currentUser.lastname}</strong>
                <label>({currentUser.email})</label>
              </MDBCardTitle>
             
              <div className="row justify-content-center">
              <label className="pt-3 mr-2" id="upload-picture-header">Change Profile Picture</label>
              <img
                      src={profileImg}
                      alt=""
                      className="rounded-circle avatar-img z-depth-1-half"
                      id="post-prof-img"
                      
                    />
              </div>
              <MDBBtn id="profile-upload-footer" >
             
              <form>
                  
                    <input
                    className="form-control form-control-sm profile-pic-upload" id="formFileSm"
                    type="file"
                    value={selectedFile}
                    onChange={uploadPicture}
                    
                    style={{backgroundColor: "transparent", border: "none", marginTop: "0", color:"white"}}
                    />
            </form>
                
              </MDBBtn>
              
            </div>
            
          </div>
          
        </MDBCard>
        {profileSuccessAlert ? <ProfilePictureSuccess></ProfilePictureSuccess>: null}
        </div>
    );
};

export default UserProfile;