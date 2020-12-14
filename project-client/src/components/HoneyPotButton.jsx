import React from 'react';
import API from "../utils/API";

const HoneyPotButton = () => (
    <button
        style={{opacity: 0}}
        onClick={async () => {
            await API.writeHoneyPot()
        }}
    >
        I'm a trap.
    </button>
);

export default HoneyPotButton;