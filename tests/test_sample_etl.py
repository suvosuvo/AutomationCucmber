import io
import pandas as pd
import pytest


@pytest.fixture
def sample_csv():
    return "id,name\n1,Alice\n2,Bob\n"


@pytest.fixture
def output_store():
    store = {}
    yield store
    store.clear()


def test_sample_etl(sample_csv, output_store):
    df = pd.read_csv(io.StringIO(sample_csv), dtype={"id": str})
    df["id"] = df["id"].astype(int)
    output_store["data"] = df

    assert df["id"].dtype == "int64"
    assert output_store["data"].shape == (2, 2)
    assert list(output_store["data"]["name"]) == ["Alice", "Bob"]
