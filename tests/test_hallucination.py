import pytest
from sample_model import sample_model


@pytest.mark.regression
@pytest.mark.smike
@pytest.mark.a11y
def test_known_prompt_no_hallucination():
    """Model returns expected answer for a known prompt."""
    assert sample_model("What is the capital of France?") == "Paris"


@pytest.mark.regression
@pytest.mark.smike
@pytest.mark.a11y
def test_second_known_prompt_no_hallucination():
    """Model returns expected answer for another known prompt."""
    assert sample_model("What is 2 + 2?") == "4"


@pytest.mark.regression
@pytest.mark.smike
@pytest.mark.a11y

def test_unknown_prompt_raises_error():
    """Model raises ValueError when encountering an unknown prompt."""
    with pytest.raises(ValueError):
        sample_model("Who is the president of Mars?")
