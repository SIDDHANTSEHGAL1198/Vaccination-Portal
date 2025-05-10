import React, { useState } from 'react';
import { useLogin, useNotify } from 'react-admin';
import { TextField, Button, Card, CardContent, Typography } from '@mui/material';

const MyLoginPage: React.FC = () => {
    const login = useLogin();
    const notify = useNotify();
    const [formState, setFormState] = useState({ username: '', password: '' });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormState({ ...formState, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await login(formState);
        } catch {
            notify('Invalid credentials', { type: 'error' });
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <Card sx={{ maxWidth: 300, margin: 'auto', mt: 10 }}>
                <CardContent>
                    <Typography variant="h6" align="center">Login</Typography>
                    <TextField
                        name="username"
                        label="Username"
                        fullWidth
                        margin="normal"
                        value={formState.username}
                        onChange={handleChange}
                    />
                    <TextField
                        name="password"
                        label="Password"
                        type="password"
                        fullWidth
                        margin="normal"
                        value={formState.password}
                        onChange={handleChange}
                    />
                    <Button type="submit" fullWidth variant="contained" sx={{ mt: 2 }}>
                        Login
                    </Button>
                </CardContent>
            </Card>
        </form>
    );
};

export default MyLoginPage;
