import React from 'react'
import {configure, shallow} from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import HomePage from './HomePage';

import AllPostsContainer from '../ContainerComponents/AllPostsContainer'


configure({adapter: new Adapter()});


describe("<Header User Testing", ()=>{
    it("Shoudld have this link",() =>{
         const wrapper = shallow(<HomePage/>)
         expect(wrapper.contains(<AllPostsContainer></AllPostsContainer>)).toEqual(true);
    })
 });