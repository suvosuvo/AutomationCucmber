import pytest
from app import app


@pytest.mark.smoke
def test_health_endpoint():
    client = app.test_client()
    resp = client.get('/health')
    assert resp.status_code == 200
    assert resp.get_json() == {'status': 'ok'}

@pytest.mark.smoke
def test_unknown_endpoint_returns_404():
    client = app.test_client()
    resp = client.get('/does-not-exist')
    assert resp.status_code == 404

