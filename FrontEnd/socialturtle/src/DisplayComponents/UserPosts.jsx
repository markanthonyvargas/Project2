import React from 'react'
import {Card, Form, Button, InputGroup} from 'react-bootstrap';
import axios from 'axios';


function UserPosts() {

    


    return (
        <div className='d-flex justify-content-center'>
        <Form>
            <Card style={{ width: '25rem' }}>
                <InputGroup.Prepend>
                {/* this field is for the input for Photos */}
                <InputGroup.Radio/>
                </InputGroup.Prepend>
            </Card>
            </Form>
         </div>   
    )
}

export default  UserPosts;