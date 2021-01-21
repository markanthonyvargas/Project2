import React, {useState} from 'react'
import { useSelector, useDispatch} from 'react-redux';
import {Navbar, Nav, NavDropdown, Form, Button, FormControl, Card} from 'react-bootstrap'
import { MDBContainer, MDBBtn, MDBModal, MDBModalBody, MDBModalHeader, MDBModalFooter } from 'mdbreact';
import {NewPostInputs} from '../actions/index'
import axios from 'axios';
import { uploadFile } from 'react-s3';
import S3FileUpload from 'react-s3';
import { v4 as uuidv4 } from 'uuid';
import PostSuccess from '../Alerts/PostSuccess';
import '../CSS/posts.css'

function MakeAPostComponent() {
    const [selectedFile, setSelectedFile] = useState(null);
    const [modal, setModal] = useState(false)
    const [successAlert, setSuccessAlert] = useState(false)
    const currentUser = JSON.parse(localStorage.getItem('UserLocal'));
    let file = null
    let postPicLocation = '';

    const config = {
        bucketName: 'project2buckethtfg',
        dirName: 'photos', /* optional */
        region: 'us-east-1',
        accessKeyId: 'AKIAYUGLMRZFKEIBNV7X',
        secretAccessKey: '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',
    }


    function uploadPicture(e) {
      setSuccessAlert(false)
      if(file) {
        console.log("file: ", file)
        console.log(file.length)
        console.log(file == null)
        console.log(file === undefined)
      let blob = file.slice(0, file.size, file.type); 
      let newFile = new File([blob], uuidv4());
      console.log("new file: ", newFile)
      console.log("e.target: ",file)
      //newFile.name = uuidv4();
        console.log(file)
        uploadFile( newFile, config)
        .then( (data)=> {
            console.log("data: ", data);
            postPicLocation = data.location;
            console.log("profile pic location: ",postPicLocation)
            
              console.log(data.status);
             
                console.log("success. trying to change local storage now...")
                console.log("profile image: ",postPicLocation)
                console.log("current users profile")
            MakeAPost(postPicLocation)
              
        })
      .catch(err => console.error(err))
      }
      else 
        MakeAPost()
    }

    const newPostDesc = useSelector(state => state.NewPost);
    const UserId = currentUser.userId;
    const dispatch = useDispatch();

    function MakeAPost(postPicLocation){

        axios.post('http://localhost:9005/Project2/socialmedia/createPost',{
            "description": newPostDesc,
            "author": {
                          userId: UserId
            },
            postImg: postPicLocation 
        }).then(function (response) 
        {
          console.log(response.status)
          if(response.status === 200)
            setSuccessAlert(true)
            //alert("Post Created!");
            //setModal(!modal)
         
        
        
          }
        )
    }

    function assignFile(e) {
        file = e.target.files[0]
    }

   

    return (
      <MDBContainer>
        
      <Nav.Link onClick={()=> setModal(!modal)} >Create A Post</Nav.Link>
      <MDBModal isOpen={modal} toggle={()=> setModal(!modal)}  className="bg-dark" id="post-modal">
      {successAlert ? <PostSuccess></PostSuccess> : null}
        <MDBModalHeader toggle={()=> setModal(!modal)} className="text-white">Make A New Post</MDBModalHeader>
        <MDBModalBody>
        <div className='d-flex justify-content-center'>
        <Card style={{ width: '25rem' }}>
            
            <Form.Group>
           
 
        
  <Form.Control  as="textarea" rows={3} placeholder="Post Description" onChange={(e) => dispatch(NewPostInputs(e.target.value))}/>
  <label className="ml-2" id="upload-picture-header">Post Image</label>
  <form>
                    <input
                    className="form-control form-control-sm" id="formFileSm"
                    type="file"
                    value={selectedFile}
                    onChange={assignFile}
                    style={{backgroundColor: "transparent", border: "none"}}
                    />
            </form>

</Form.Group>


            

        </Card>


       
        </div>
        </MDBModalBody>
        <MDBModalFooter>
          <MDBBtn color="secondary" onClick={()=> setModal(!modal)}>Close</MDBBtn>
          <MDBBtn color="primary" onClick={uploadPicture}>Post</MDBBtn>
        </MDBModalFooter>
      </MDBModal>
    </MDBContainer>
    )
}

export default MakeAPostComponent;