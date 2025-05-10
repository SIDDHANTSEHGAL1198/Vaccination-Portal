import React, { useEffect, useState } from 'react';
import { Card, CardContent, Typography } from '@mui/material';
import axios from 'axios';

interface VaccinationDrive {
    id: number;
    drive_date: string;
    location: string;
}

interface DashboardData {
    totalStudents: number;
    vaccinatedStudents: number;
    upcomingDrives: VaccinationDrive[];
}

const Dashboard: React.FC = () => {
    const [data, setData] = useState<DashboardData | null>(null);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        axios.get<DashboardData>('/api/dashboard')
            .then(response => {
                console.log('Dashboard response:', response.data);
                setData(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error('Failed to fetch dashboard data:', error);
                setLoading(false);
            });
    }, []);

    
    if (loading) {
        return <Typography>Loading dashboard...</Typography>;
    }

    if (!data) {
        return <Typography>Unable to load dashboard data.</Typography>;
    }

    return (
        <div style={{ display: 'flex', gap: '1rem', flexWrap: 'wrap' }}>
            <Card sx={{ minWidth: 275 }}>
                <CardContent>
                    <Typography variant="h6">Students Registered</Typography>
                    <Typography>{data.totalStudents}</Typography>
                </CardContent>
            </Card>
            <Card sx={{ minWidth: 275 }}>
                <CardContent>
                    <Typography variant="h6">Students Vaccinated</Typography>
                    <Typography>{data.vaccinatedStudents}</Typography>
                </CardContent>
            </Card>
            <Card sx={{ minWidth: 275 }}>
                <CardContent>
                {!data.upcomingDrives || data.upcomingDrives.length === 0 ? (
            <Typography color="text.secondary">No upcoming drives</Typography>
            ) : (
            data.upcomingDrives.map((drive) => (
            <Typography key={drive.id}>
                {drive.drive_date} - {drive.location}
            </Typography>
    ))
)}

                </CardContent>
            </Card>
        </div>
    );
};

export default Dashboard;
