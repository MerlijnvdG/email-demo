const API_BASE_URL = '/api';

export class MailService {
    static async sendMail(to, subject, body) {
        const response = await fetch(`${API_BASE_URL}/email`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({to, subject, body}),
        });

        if (!response.ok) {
            throw new Error('Failed to send email');
        }
    }

    static async sendWelcomeMail(to, name) {
        const response = await fetch(`${API_BASE_URL}/welcome`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({to, name}),
        });
    }
}